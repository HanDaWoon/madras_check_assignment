package madras_check.admin.dto.common;

public class PaginationParam {
    private Integer page = 1;
    private Integer recordSize = 10;
    private Integer pageSize = 5;
    private Integer offset = 0;

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setRecordSize(Integer recordSize) {
        this.recordSize = recordSize;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getRecordSize() {
        return recordSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getOffset() {
        return offset;
    }

    @Override
    public String toString() {
        return "PaginationParam{" +
            "page=" + page +
            ", recordSize=" + recordSize +
            ", pageSize=" + pageSize +
            ", offset=" + offset +
            '}';
    }

}
