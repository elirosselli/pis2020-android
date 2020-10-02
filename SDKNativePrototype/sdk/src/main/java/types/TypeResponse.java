package types;

public abstract class TypeResponse {


    //TODO casteo a error directo

    public boolean isSucceed() {
        return succeed;
    }

    private boolean succeed;

    public TypeResponse(boolean succeed) {
        this.succeed = succeed;
    }
}
