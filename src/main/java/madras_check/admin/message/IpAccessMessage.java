package madras_check.admin.message;

public enum IpAccessMessage {
    ERROR("IP 접근 제한 설정 중 오류가 발생했습니다."),
    DUPLICATE_ALLOWED_IP("중복되는 IP 접근 제한 설정입니다."),
    INVALID_IP("유효하지 않은 IP 주소입니다."),
    INVALID_DATETIME("유효하지 않은 날짜 및 시간 형식입니다."),
    TOO_LONG_MEMO("메모는 20자 이하로 입력해주세요."),
    MEMO_REQUIRED("메모를 입력해주세요."),
    IP_REQUIRED("IP 주소를 입력해주세요."),
    DATETIME_REQUIRED("날짜 및 시간을 입력해주세요."),
    START_DATE_AFTER_END_DATE("시작 날짜가 종료 날짜보다 빠를 수 없습니다."),
    SUCCESS("IP 접근 제한 설정이 완료되었습니다."),
    ;
    private final String message;

    IpAccessMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
