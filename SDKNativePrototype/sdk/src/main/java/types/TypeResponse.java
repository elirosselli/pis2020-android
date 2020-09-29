package types;

public abstract class TypeResponse {

    public boolean isSucceed() {
        return succeed;
    }

    private boolean succeed;

    public TypeResponse(boolean succeed) {
        this.succeed = succeed;
    }


}
