package org.featx.spec.feature;

import org.featx.spec.enums.BusinessError;
import org.featx.spec.error.BusinessException;
import org.featx.spec.model.BaseResponse;

/**
 * @author Excepts
 * @since 2019/10/27 10:00
 */
public class BaseExceptionHandler {

    //    @ResponseStatus(HttpStatus.BAD_REQUEST)
    //    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class,
    //            HttpRequestMethodNotSupportedException.class, IllegalStateException.class})
    protected <R> BaseResponse<R> handleException(Exception e) {
//        log.error("", e);
        return BaseResponse.occur(BusinessError.PARAMETER_TYPE);
    }

    //    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    //    @ExceptionHandler(value = BusinessException.class)
    protected BaseResponse<Object> handleBusinessException(BusinessException e) {
//        log.error("Business error {}, {}", e.getBusinessError(), e.getExtra());
        return BaseResponse.occur(e.getBusinessError(), e.getExtra());
    }

}