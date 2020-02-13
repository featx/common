package org.featx.spec.model;

import org.featx.spec.constant.ErrorCode;
import org.featx.spec.enums.BusinessError;
import org.featx.spec.util.StringUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Excepts
 * @since 2019/10/27 11:12
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PageResponse<R> extends ListResponse<R> {

    private Integer total;

    private Integer page;

    private PageResponse(int code, String message, List<R> result) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(result);
    }

    public PageResponse<R> total(Integer total) {
        this.total = total;
        return this;
    }

    public PageResponse<R> page(Integer page) {
        this.page = page;
        return this;
    }

    public static <R> PageResponse<R> succeeded(List<R> result)  {
        return new PageResponse<>(ErrorCode.NO_ERROR, StringUtil.empty(), result);
    }

    public static <R> PageResponse<R> occur(BusinessError businessError, List<R> extra) {
        return new PageResponse<>(businessError.getCode(), businessError.getMessage(), extra);
    }
}
