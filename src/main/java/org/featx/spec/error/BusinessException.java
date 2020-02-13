package org.featx.spec.error;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.featx.spec.enums.BusinessError;

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