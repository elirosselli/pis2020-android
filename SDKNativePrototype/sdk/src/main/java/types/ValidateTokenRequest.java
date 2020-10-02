package types;

import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.pack.sdk.RequestsCallback;

import org.json.JSONObject;

public class ValidateTokenRequest extends TypeRequest {

    @Override
    public StringRequest doRequest(RequestsCallback callback) {
        return null;
    }

    @Override
    public TypeResponse processResponse(JSONObject s) {
        return null;
    }
}
