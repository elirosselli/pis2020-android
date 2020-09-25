package types;

import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

public class RefreshTokenRequest extends TypeRequest {
    private String grant_type;
    private String refresh_token;

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
    public StringRequest doRequest(RequestFuture future) {
        return null;
    }

    @Override
    public void processResponse(JSONObject s) {

    }
}
