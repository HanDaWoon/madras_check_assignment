package madras_check.admin.service;

import madras_check.admin.entity.MUser;
import madras_check.admin.mapper.MUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MUserService {
    private final MUserMapper mUserMapper;

    @Autowired
    public MUserService(MUserMapper mUserMapper) {
        this.mUserMapper = mUserMapper;
    }

    public MUser findByEmail(String email) {
        return mUserMapper.selectMUserByEmail(email);
    }
}