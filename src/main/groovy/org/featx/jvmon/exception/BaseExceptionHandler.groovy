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
    BaseResponse<Object> handleConstraintViolationException(Exception e) {
        return BaseResponse.occur(BusinessError.PARAMETER_TYPE)
    }

    //    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    //    @ExceptionHandler(value = BusinessException.class)
    BaseResponse<Object> handleInvalidUser(BusinessException e) {
        return BaseResponse.occur(e.businessError, e.extra)
    }

}