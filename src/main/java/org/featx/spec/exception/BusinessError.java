package org.featx.spec.exception;

import lombok.Getter;

/**
 * @author Excepts
 * @since 2019/10/12 11:20
 */
@Getter
public enum BusinessError {
    /**
     *
     */
    PARAMETER_LOST(ErrorCode.PARAMETER_LOST, "Lost some parameter"),
    /**
     *
     */
    PARAMETER_TYPE(ErrorCode.PARAMETER_TYPE, "Parameter type error"),
    /**
     *
     */
    PARAMETER_INVALID(ErrorCode.PARAMETER_INVALID, "Parameter error"),
    ;
    private int code;

    private String message;

    BusinessError(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
