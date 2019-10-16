package org.featx.jvmon.model

import lombok.Data
import lombok.EqualsAndHashCode
import org.featx.jvmon.exception.BusinessError
import org.featx.jvmon.exception.ErrorCode

/**
 * @author Excepts
 * @since 2019/10/12 11:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
class FlowResponse<T> extends ListResponse<T> {

    private String previous

    private String next

    private FlowResponse(int code, String msg, List<? extends T> result) {
        super(code, msg, result)
    }

    static <R>FlowResponse<R> succeeded(List<R> result)  {
        return FlowResponse(ErrorCode.NO_ERROR, null, result)
    }

    static <R>FlowResponse<R> occur(BusinessError businessError) {
        return FlowResponse(businessError.code, businessError.message, null)
    }

    static <R>FlowResponse<R> occur(BusinessError businessError, List<R> extra) {
            return FlowResponse(businessError.code, businessError.message, extra)
    }
}
