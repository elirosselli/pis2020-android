package types;

import android.os.Build;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.pack.sdk.ContConfiguracion;
import com.pack.sdk.RequestsCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.RequiresApi;

public class UserInfoRequest extends TypeRequest{

    final String apiLink = "https://auth-testing.iduruguay.gub.uy/oidc/v1/userinfo";

    @Override
    public StringRequest doRequest(final RequestsCallback callback) {
        ContConfiguracion conf = ContConfiguracion.getInstance();

        final String accessToken = conf.getAccess_token();

        Log.i("UI TOKEN", accessToken);
        StringRequest request = new StringRequest(Request.Method.POST, apiLink,
            new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response) {
                    String s;
                    s = response.trim();
                    JSONObject obj = null;
                    try {
                        obj = new JSONObject(s);
                    } catch (Throwable t) {
                    }
                    callback.onSuccess(processResponse(obj));
                }
            },
            new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse(VolleyError error) {
                    callback.onError(new ErrorResponse());
                }
            }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headerMap = new HashMap<String, String>();
                String auth = "Bearer "
                        +  accessToken;
                headerMap.put("Authorization", auth);

                return headerMap;
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT) // Android 4.4 +
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String parsed;
                parsed = new String(response.data, StandardCharsets.UTF_8);
                return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
            }

        };

        return request;
    }

    @Override
    public TypeResponse processResponse(JSONObject response){ // TODO return response type

        Log.i("Response", response.toString());
        try {
            return new UserInfoResponse(response, ContConfiguracion.getInstance().getScope());
        } catch (JSONException e) {
            return null;
        }

    }
}
