package madras_check.admin.mapper;

import madras_check.admin.entity.MUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MUserMapper {

    MUser selectMUserByEmail(String email);
}
