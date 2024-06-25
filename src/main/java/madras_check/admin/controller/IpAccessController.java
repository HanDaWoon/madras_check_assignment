package madras_check.admin.controller;

import madras_check.admin.dto.IpAccess.AddIpAccessReq;
import madras_check.admin.dto.IpAccess.IpAccessRes;
import madras_check.admin.dto.common.Pagination;
import madras_check.admin.dto.common.PaginationParam;
import madras_check.admin.dto.common.ResponseBad;
import madras_check.admin.dto.common.ResponseOk;
import madras_check.admin.entity.IpAccess;
import madras_check.admin.message.IpAccessMessage;
import madras_check.admin.service.IpAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ip-access")
public class IpAccessController {
    private final IpAccessService ipAccessService;

    @Autowired
    public IpAccessController(IpAccessService ipAccessService) {
        this.ipAccessService = ipAccessService;
    }

    /**
     * Add IP Access
     *
     * @param addIpAccessReq IP Access Request
     * @return ResponseEntity
     */
    @PostMapping("")
    public ResponseEntity<?> addIpAccess(@RequestBody AddIpAccessReq addIpAccessReq) {
        try {
            // Validation
            if (addIpAccessReq.getIpAddress() == null || addIpAccessReq.getIpAddress().isBlank()) {
                return new ResponseBad(IpAccessMessage.IP_REQUIRED).toResponseEntity();
            }
            if (!addIpAccessReq.getIpAddress().matches("^(\\d{1,3}\\.){3}\\d{1,3}$")) {
                return new ResponseBad(IpAccessMessage.INVALID_IP).toResponseEntity();
            }
            if (addIpAccessReq.getMemo() == null || addIpAccessReq.getMemo().isBlank()) {
                return new ResponseBad(IpAccessMessage.MEMO_REQUIRED).toResponseEntity();
            }
            if (addIpAccessReq.getMemo().length() > 20) {
                return new ResponseBad(IpAccessMessage.TOO_LONG_MEMO).toResponseEntity();
            }
            if (addIpAccessReq.getStartDate() == null || addIpAccessReq.getEndDate() == null) {
                return new ResponseBad(IpAccessMessage.DATETIME_REQUIRED).toResponseEntity();
            }
            if (addIpAccessReq.getStartDate().after(addIpAccessReq.getEndDate())) {
                return new ResponseBad(IpAccessMessage.START_DATE_AFTER_END_DATE).toResponseEntity();
            }

            // Add IP Access
            if (ipAccessService.addIpAccess(addIpAccessReq)) {  // Success
                return new ResponseOk(IpAccessMessage.SUCCESS).toResponseEntity();
            }
            return new ResponseBad(IpAccessMessage.ERROR).toResponseEntity();
        } catch (DataIntegrityViolationException e) {   // Duplicate IP Address
            return new ResponseBad(IpAccessMessage.DUPLICATE_ALLOWED_IP).toResponseEntity();
        } catch (Exception e) { // Error
            return new ResponseBad(IpAccessMessage.ERROR).toResponseEntity();
        }
    }

    /**
     * Get IP Access
     *
     * @param paginationParam Pagination Param
     * @param ip              IP Address
     * @param memo            Memo
     * @param startDate       Start Date
     * @param endDate         End Date
     * @return ResponseEntity
     */
    @GetMapping("")
    public ResponseEntity<?> getIpAccess(
        PaginationParam paginationParam,
        @RequestParam(required = false) String ip,
        @RequestParam(required = false) String memo,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startDate,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date endDate
    ) {
        // 페이지네이션 처리
        Pagination pagination = new Pagination(ipAccessService.getIpAccessCount(ip, memo, startDate, endDate), paginationParam);

        // IP Access 조회
        List<IpAccess> result = ipAccessService.getIpAccess(pagination.getPaginationParam(), ip, memo, startDate, endDate);

        IpAccessRes resultWithPagination = new IpAccessRes(result, pagination);
        return new ResponseOk(resultWithPagination).toResponseEntity();
    }

    /**
     * Delete IP Access
     *
     * @param id IP Access ID
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIpAccess(@PathVariable Integer id) {
        return new ResponseOk(ipAccessService.deleteIpAccess(id)).toResponseEntity();
    }
}
