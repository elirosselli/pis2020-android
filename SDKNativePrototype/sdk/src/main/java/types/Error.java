package types;

public class Error {
    private String code;
    private String desc;

    //  Constructors
    public Error() {
        this.code = null;
        this.desc = null;
    }

    public Error(String code, String desc) {
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
