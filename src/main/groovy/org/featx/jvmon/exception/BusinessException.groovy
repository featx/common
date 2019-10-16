package org.featx.jvmon.exception

import lombok.Data
/**
 * @author Excepts
 */
@Data
class BusinessException<T> extends RuntimeException {

    private BusinessError businessError

    private T extra

    @Override
    String getMessage() {
        return businessError.getMessage()
    }
}