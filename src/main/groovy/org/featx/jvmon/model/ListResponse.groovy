package org.featx.jvmon.model

import lombok.Data
import lombok.EqualsAndHashCode
import org.featx.jvmon.exception.BusinessError
import org.featx.jvmon.exception.ErrorCode

/**
 * @author Excepts* @since 2019/10/12 11:01
 */
@Data
@EqualsAndHashCode(callSuper = true)
class ListResponse<T> extends BaseResponse<List<T>> {

    Integer getSize() {
        return Optional.ofNullable(getResult()).map { t -> t.size() }
                .orElse(0) as Integer
    }

    static <R> ListResponse<R> succeeded(List<R> result) {
        return ListResponse(ErrorCode.NO_ERROR, null, result)
    }

    static <R> ListResponse<R> occur(BusinessError businessError) {
        return ListResponse(businessError.getCode(), businessError.getMessage(), null)
    }

    static <R> ListResponse<R> occur(BusinessError businessError, List<R> extra) {
        return ListResponse(businessError.getCode(), businessError.getMessage(), extra)
    }

}