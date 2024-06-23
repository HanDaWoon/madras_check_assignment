package madras_check.admin.service;

import madras_check.admin.dto.IpAccess.AddIpAccessReq;
import madras_check.admin.dto.common.PaginationParam;
import madras_check.admin.entity.IpAccess;
import madras_check.admin.mapper.IpAccessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IpAccessService {
    private final IpAccessMapper ipAccessMapper;

    @Autowired
    public IpAccessService(IpAccessMapper ipAccessMapper) {
        this.ipAccessMapper = ipAccessMapper;
    }

    public Boolean addIpAccess(AddIpAccessReq addIpAccessReq) {
        return ipAccessMapper.insertIpAccess(addIpAccessReq) == 1;
    }

    public List<IpAccess> getIpAccess(PaginationParam paginationParam, String ip, String memo, Date startDate, Date endDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("ip", ip);
        params.put("memo", memo);
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        params.put("offset", paginationParam.getOffset());
        params.put("recordSize", paginationParam.getRecordSize());
        return ipAccessMapper.selectIpAccess(params);
    }

    public int getIpAccessCount(String ip, String memo, Date startDate, Date endDate) {
        return ipAccessMapper.selectIpAccessCount(ip, memo, startDate, endDate);
    }

    public Boolean deleteIpAccess(int id) {
        return ipAccessMapper.deleteIpAccess(id) == 1;
    }
}
