package types;

import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.pack.sdk.RequestsCallback;

import org.json.JSONObject;


public abstract class TypeRequest {

    public abstract StringRequest doRequest(RequestsCallback callback);

    public abstract TypeResponse processResponse(JSONObject s);
}
