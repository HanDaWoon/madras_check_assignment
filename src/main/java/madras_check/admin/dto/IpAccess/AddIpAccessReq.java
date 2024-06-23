package madras_check.admin.dto.IpAccess;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AddIpAccessReq {
    private String ipAddress;
    private String memo;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    public String getIpAddress() {
        return ipAddress;
    }

    public String getMemo() {
        return memo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
