package org.featx.spec.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Excepts
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {

    private BusinessError businessError;

    private Object extra;

    @Override
    public String getMessage() {
        return businessError.getMessage();
    }
}