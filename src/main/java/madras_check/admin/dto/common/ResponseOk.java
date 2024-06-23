package madras_check.admin.dto.common;

import madras_check.admin.message.ResponseMessage;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public record ResponseOk(Object body) {
    public ResponseEntity<Map<String, Object>> toResponseEntity() {
        if (body.getClass().equals(String.class) || body.getClass().isEnum()) {
            return ResponseEntity.ok(Map.of(
                ResponseMessage.STATUS.getKey(), ResponseMessage.SUCCESS.getKey(),
                ResponseMessage.MESSAGE.getKey(), body.toString()
            ));
        }
        return ResponseEntity.ok(Map.of(
            ResponseMessage.STATUS.getKey(), ResponseMessage.SUCCESS.getKey(),
            ResponseMessage.DATA.getKey(), body
        ));
    }
}