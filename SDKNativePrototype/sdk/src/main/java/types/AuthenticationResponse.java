package types;

public class AuthenticationResponse extends TypeResponse {
    private String code;
    private String state;

    //  Constructor
    public AuthenticationResponse(String code) {
        this.code = code;
        this.state = null;
    }

    //  Getter & Setter for code
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    //  Getter & Setter for state
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
