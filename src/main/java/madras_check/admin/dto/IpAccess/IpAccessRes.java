package madras_check.admin.dto.IpAccess;

import madras_check.admin.dto.common.Pagination;
import madras_check.admin.entity.IpAccess;

import java.util.List;

public record IpAccessRes(
    List<IpAccess> ipAccessList, Pagination pagination
) {
}
