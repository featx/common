package org.featx.spec.exception;

import org.featx.spec.model.BaseResponse;

/**
 * @author Excepts
 * @since 2019/10/12 10:00
 */
public class BaseExceptionHandler {

    //    @ResponseStatus(HttpStatus.BAD_REQUEST)
    //    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class,
    //            HttpRequestMethodNotSupportedException.class, IllegalStateException.class})
    <R> BaseResponse<R> handleConstraintViolationException(Exception e) {
        return BaseResponse.occur(BusinessError.PARAMETER_TYPE);
    }

    //    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    //    @ExceptionHandler(value = BusinessException.class)
    BaseResponse<Object> handleInvalidUser(BusinessException e) {
        return BaseResponse.occur(e.getBusinessError(), e.getExtra());
    }

}