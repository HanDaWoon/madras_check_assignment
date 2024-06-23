package madras_check.admin.message;

public enum ResponseMessage {
    STATUS("status"),
    MESSAGE("message"),
    DATA("data"),
    SUCCESS("success"),
    FAILED("failed"),
    ERROR("error");

    private final String key;

    ResponseMessage(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
