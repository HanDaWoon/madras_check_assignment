package madras_check.admin.dto.common;

import madras_check.admin.message.ResponseMessage;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public record ResponseBad(Object body) {
    public ResponseEntity<Map<String, Object>> toResponseEntity() {
        return ResponseEntity.badRequest().body(Map.of(
            ResponseMessage.STATUS.getKey(), ResponseMessage.FAILED.getKey(),
            ResponseMessage.MESSAGE.getKey(), body.toString()
        ));
    }
}
