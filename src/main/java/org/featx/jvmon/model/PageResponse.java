package org.featx.jvmon.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.featx.jvmon.exception.ErrorCode;

import java.util.List;

/**
 * @author Excepts
 * @since 2019/10/12 11:12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PageResponse<R> extends ListResponse<R> {

    private Integer total;

    private Integer page;

    public PageResponse<R> total(Integer total) {
        this.total = total;
        return this;
    }

    public PageResponse<R> page(Integer page) {
        this.page = page;
        return this;
    }

    public PageResponse<R> with(int page, int total) {
        this.total = total;
        this.page = page;
        return this;
    }

    private PageResponse(int code, String message, List<R> result) {
        this.setCode(code);
        this.setMessage(message);
        this.setResult(result);
    }

    public static <R> PageResponse<R> succeeded(List<R> result)  {
        return new PageResponse<>(ErrorCode.NO_ERROR, null, result);
    }
}
