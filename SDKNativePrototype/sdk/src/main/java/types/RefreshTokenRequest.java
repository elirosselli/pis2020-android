package types;

import android.os.Build;
import android.util.Base64;
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

public class RefreshTokenRequest extends TypeRequest {
    private String grant_type;
    private String refresh_token;
    final String apiLink = "https://auth-testing.iduruguay.gub.uy/oidc/v1/token";

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }


    @Override
    public StringRequest doRequest(final RequestsCallback callback) {
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
                            callback.onError(new ErrorResponse("str","Error en los datos recibidos. Formato incorrecto."));
                        }
                        callback.onSuccess(processResponse(obj));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onError(new ErrorResponse());
                    }
                }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                String USERNAME = ContConfiguracion.getInstance().getClient_id(); // TODO change to config.Code
                String PASSWORD = ContConfiguracion.getInstance().getClient_secret(); //TODO change to config.Secret
                Map<String, String> headerMap = new HashMap<String, String>();
                String credentials = USERNAME+":"+PASSWORD;
                String auth = "Basic "
                        + Base64.encodeToString(credentials.getBytes(),
                        Base64.NO_WRAP);
                headerMap.put("Authorization", auth);
                headerMap.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

                return headerMap;
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT) // Android 4.4 +
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String parsed;
                parsed = new String(response.data, StandardCharsets.UTF_8);
                return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("grant_type", "refresh_token");
                params.put("refresh_token", refresh_token);
                return params;
            }
        };

        return request;
    }

    @Override
    public TypeResponse processResponse(JSONObject response) {
        ContConfiguracion conf = ContConfiguracion.getInstance();
        try {
            String access_token = response.getString("access_token");
            conf.setAccess_token(access_token);

            String refresh_token = response.getString("refresh_token");
            conf.setRefresh_token(refresh_token);

            String token_type = response.getString("token_type");
            conf.setToken_type(token_type);

            int expires_in = response.getInt("expires_in");
            conf.setExpires_in(expires_in);

            String id_token = response.getString("id_token");

            Log.i("Token", access_token);
            conf.setId_token(id_token);
            TokenResponse tr = new TokenResponse(access_token, token_type,id_token, expires_in, refresh_token );

            return tr;

        } catch (JSONException e) {
            e.printStackTrace();
            return new ErrorResponse("","");
        }
    }
}
