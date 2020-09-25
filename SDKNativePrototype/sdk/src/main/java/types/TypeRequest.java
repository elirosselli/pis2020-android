package types;

import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;


public abstract class TypeRequest {

    public abstract StringRequest doRequest(RequestFuture future);

    public abstract void processResponse(JSONObject s);
}
