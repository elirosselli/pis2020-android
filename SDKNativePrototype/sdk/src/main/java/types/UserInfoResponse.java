package types;

import org.json.JSONObject;

public class UserInfoResponse {
    private JSONObject info;

    //  Constructor
    public UserInfoResponse(JSONObject info) {
        this.info = info;
    }

    //  Getter & Setter for info
    public JSONObject getInfo() {
        return info;
    }

    public void setInfo(JSONObject info) {
        this.info = info;
    }
}
