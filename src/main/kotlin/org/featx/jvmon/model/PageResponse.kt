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
class PageResponse<T> private constructor(code: Int, msg: String?, result: List<T>?) :
        ListResponse<T>(code, msg, result) {

    var page: Int? = null
        set(page) {
            field = this.page
        }

    var total: Int? = null
        set(total) {
            field = this.total
        }

    companion object {
        fun <R> succeeded(result: List<R>): PageResponse<R> {
            return PageResponse(ErrorCode.NO_ERROR, null, result)
        }

        fun <R> occur(businessError: BusinessError): PageResponse<R> {
            return PageResponse(businessError.code, businessError.message, null)
        }

        fun <R> occur(businessError: BusinessError, extra: List<R>): PageResponse<R> {
            return PageResponse(businessError.code, businessError.message, extra)
        }
    }
}
