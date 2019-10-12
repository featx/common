package org.featx.jvmon.model

import org.featx.jvmon.exception.BusinessError
import org.featx.jvmon.exception.ErrorCode
import java.util.*

/**
 * @author Excepts
 * @since 2019/10/12 11:01
 */
open class ListResponse<T>(code: Int, msg: String?, result: List<T>?) :
        BaseResponse<List<T>>(code, msg, result) {

    private val size: Int?
        get() = Optional.ofNullable(getResult())
                .map<Int> { t -> t.size }
                .orElse(0)

    companion object {
        fun <R> succeeded(result: List<R>): ListResponse<R> {
            return ListResponse(ErrorCode.NO_ERROR, null, result)
        }

        fun <R> occur(businessError: BusinessError): ListResponse<R> {
            return ListResponse(businessError.code, businessError.message, null)
        }

        fun <R> occur(businessError: BusinessError, extra: List<R>): ListResponse<R> {
            return ListResponse(businessError.code, businessError.message, extra)
        }
    }
}