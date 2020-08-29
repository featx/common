package org.featx.spec.error;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.featx.spec.enums.BaseEnum;

/**
 * @author Excepts
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -8691189581874426321L;

    private int code;

    private Object extra;

    private BusinessException(int code, String message, Object extra) {
        super(message);
        this.code = code;
    }

    public static BusinessException of(int code, String message) {
        return new BusinessException(code, message, null);
    }

    public static BusinessException of(int code, String message, Object extra) {
        return new BusinessException(code, message, extra);
    }

    public static BusinessException of(BaseEnum baseEnum) {
        return new BusinessException(baseEnum.getCode(), baseEnum.getMessage(), null);
    }

    public static BusinessException of(BaseEnum baseEnum, Object extra) {
        return new BusinessException(baseEnum.getCode(), baseEnum.getMessage(), extra);
    }

}