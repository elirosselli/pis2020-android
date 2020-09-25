package types;

import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

public class LogoutRequest extends TypeRequest {
    private String id_token_hint;
    private String post_logout_redirect_uri;
    private String state;

    public String getId_token_hint() {
        return id_token_hint;
    }

    public void setId_token_hint(String id_token_hint) {
        this.id_token_hint = id_token_hint;
    }

    public String getPost_logout_redirect_uri() {
        return post_logout_redirect_uri;
    }

    public void setPost_logout_redirect_uri(String post_logout_redirect_uri) {
        this.post_logout_redirect_uri = post_logout_redirect_uri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public StringRequest doRequest(RequestFuture future) {
        return null;
    }

    @Override
    public TypeResponse processResponse(JSONObject s) {
        return null;
    }
}
