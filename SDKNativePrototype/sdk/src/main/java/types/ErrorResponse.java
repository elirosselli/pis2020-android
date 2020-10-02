package types;

public class ErrorResponse extends TypeResponse{
    private String code;
    private String desc;

    //  Constructors
    public ErrorResponse() {
        super(false);
        this.code = null;
        this.desc = null;
    }

    public ErrorResponse(String code, String desc) {
        super(false);
        this.code = code;
        this.desc = desc;
    }

    // Getter & Setter for id_error
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // Getter & Setter for desc
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
