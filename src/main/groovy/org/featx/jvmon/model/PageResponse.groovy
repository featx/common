package org.featx.jvmon.model

import lombok.Data
import lombok.EqualsAndHashCode
import org.featx.jvmon.exception.BusinessError
import org.featx.jvmon.exception.ErrorCode

/**
 * @author Excepts
 * @since 2019/10/12 11:12
 */
@Data
@EqualsAndHashCode(callSuper = true)
class PageResponse<T> extends ListResponse<T> {

    private String previous

    private String next

    private PageResponse(int code, String msg, List<? extends T> result) {
        super(code, msg, result)
    }

    static <R>PageResponse<R> succeeded(List<R> result)  {
        return PageResponse(ErrorCode.NO_ERROR, null, result)
    }

    static <R>PageResponse<R> occur(BusinessError businessError) {
        return PageResponse(businessError.getCode(), businessError.getMessage(), null)
    }

    static <R>PageResponse<R> occur(BusinessError businessError, List<R> extra) {
        return PageResponse(businessError.getCode(), businessError.getMessage(), extra)
    }
}
