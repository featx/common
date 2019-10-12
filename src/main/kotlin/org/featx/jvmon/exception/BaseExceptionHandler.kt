package org.featx.jvmon.exception

import lombok.extern.slf4j.Slf4j
import org.featx.jvmon.model.BaseResponse

/**
 * @author Excepts
 * @since 2019/10/12 10:00
 */
@Slf4j
class BaseExceptionHandler {

    //    @ResponseStatus(HttpStatus.BAD_REQUEST)
    //    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class,
    //            HttpRequestMethodNotSupportedException.class, IllegalStateException.class})
    fun <T> handleConstraintViolationException(e: Exception): BaseResponse<T> {
        return BaseResponse.occur(BusinessError.PARAMETER_TYPE)
    }

    //    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    //    @ExceptionHandler(value = BusinessException.class)
    fun <T> handleInvalidUser(e: BusinessException): BaseResponse<Any?> {
        return BaseResponse.occur(e.businessError, e.extra)
    }

}