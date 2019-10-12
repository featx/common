package org.featx.jvmon.model

import org.featx.jvmon.exception.BusinessError
import org.featx.jvmon.exception.ErrorCode

/**
 * @author Excepts
 * @since 2019/10/12 11:14
 */
class FlowResponse<T> private constructor(code: Int, msg: String?, result: List<T>?) :
        ListResponse<T>(code, msg, result) {

    var previous: String? = null
        set(previous) {
            field = this.previous
        }

    var next: String? = null
        set(next) {
            field = this.next
        }

    companion object {
        fun <R> succeeded(result: List<R>): FlowResponse<R> {
            return FlowResponse(ErrorCode.NO_ERROR, null, result)
        }

        fun <R> occur(businessError: BusinessError): FlowResponse<R> {
            return FlowResponse(businessError.code, businessError.message, null)
        }

        fun <R> occur(businessError: BusinessError, extra: List<R>): FlowResponse<R> {
            return FlowResponse(businessError.code, businessError.message, extra)
        }
    }
}
