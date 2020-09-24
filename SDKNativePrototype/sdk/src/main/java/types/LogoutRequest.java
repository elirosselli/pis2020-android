package types;

public class LogoutRequest extends Request {
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
}
