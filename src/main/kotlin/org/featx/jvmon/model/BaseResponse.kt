package org.featx.jvmon.model

import org.featx.jvmon.exception.BusinessError
import org.featx.jvmon.exception.ErrorCode

/**
 * @author Excepts
 * @since 2019/10/12 10:03
 */
open class BaseResponse<R>(
        /**
         * 错误码 0 为成功
         */
        private val code: Int,
        /**
         * code不为0时，错误说明
         */
        private val msg: String?,
        /**
         *
         */
        private val result: R?) {

    fun getResult(): R? {return result;}

    companion object {

        fun <R> succeeded(result: R): BaseResponse<R> {
            return BaseResponse(ErrorCode.NO_ERROR, null, result)
        }

        fun <R> occur(businessError: BusinessError): BaseResponse<R> {
            return BaseResponse(businessError.code, businessError.message, null)
        }

        fun <R> occur(businessError: BusinessError, extra: R): BaseResponse<R> {
            return BaseResponse(businessError.code, businessError.message, extra)
        }
    }
}