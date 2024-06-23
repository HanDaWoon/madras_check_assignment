package madras_check.admin.controller;

import madras_check.admin.dto.common.ResponseBad;
import madras_check.admin.dto.common.ResponseOk;
import madras_check.admin.entity.MUser;
import madras_check.admin.message.MUserMessage;
import madras_check.admin.service.MUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final MUserService mUserService;

    @Autowired
    public UserController(MUserService mUserService) {
        this.mUserService = mUserService;
    }

    @RequestMapping("/user")
    public ResponseEntity<?> getUserDetailsAfterLogin(Authentication authentication) {
        if (authentication == null) {
            return new ResponseBad(MUserMessage.AUTHENTICATION_NULL).toResponseEntity();
        }
        MUser mUser = mUserService.findByEmail(authentication.getName());
        if (mUser != null) {
            return new ResponseOk(mUser).toResponseEntity();
        } else {
            return new ResponseBad(MUserMessage.USER_NOT_FOUND).toResponseEntity();
        }
    }
}
