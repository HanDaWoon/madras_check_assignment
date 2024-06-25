package madras_check.admin.dto.IpAccess;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AddIpAccessReq {
    private String ipAddress;
    private String memo;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date startDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
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
