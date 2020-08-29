package org.featx.spec.error;

import org.featx.spec.enums.BusinessError;
import org.featx.spec.model.BaseResponse;

/**
 * @author Excepts
 * @since 2019/10/12 10:00
 */
public class BaseExceptionHandler {

    protected <R> BaseResponse<R> handleConstraintViolationException(Exception e) {
        return BaseResponse.occur(BusinessError.PARAMETER_TYPE);
    }

    protected BaseResponse<Object> handleInvalidUser(BusinessException e) {
        return BaseResponse.occur(e.getCode(), e.getMessage(), e.getExtra());
    }

    protected BaseResponse<Object> handleBusinessException(BusinessException e) {
        return BaseResponse.occur(e.getCode(), e.getMessage(), e.getExtra());
    }
}