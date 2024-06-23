package madras_check.admin.mapper;

import madras_check.admin.dto.IpAccess.AddIpAccessReq;
import madras_check.admin.entity.IpAccess;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface IpAccessMapper {
    Integer insertIpAccess(AddIpAccessReq addIpAccessReq);

    List<IpAccess> selectIpAccess(Map<String, Object> params);

    int selectIpAccessCount(String ip, String memo, Date startDate, Date endDate);

    Integer deleteIpAccess(int id);
}
