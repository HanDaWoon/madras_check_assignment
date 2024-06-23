package madras_check.admin.message;

public enum MUserMessage {
    USER_NOT_FOUND("사용자를 찾을 수 없습니다."),
    USER_NOT_LOGGED_IN("로그인이 필요합니다."),
    AUTHENTICATION_NULL("인증 정보가 없습니다."),
    AUTHENTICATION_TOKEN_INVALID("인증 토큰이 유효하지 않습니다."),
    ERROR_LOGIN("로그인 중 오류가 발생했습니다.");

    private final String message;

    MUserMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
