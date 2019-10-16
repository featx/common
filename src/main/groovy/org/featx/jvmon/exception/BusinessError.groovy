package org.featx.jvmon.exception

import lombok.Getter

/**
 * @author Excepts
 * @since 2019/10/12 11:20
 */
@Getter
enum BusinessError {

    PARAMETER_LOST(ErrorCode.PARAMETER_LOST, "缺少参数"),
    PARAMETER_TYPE(ErrorCode.PARAMETER_TYPE, "参数类型错误"),
    PARAMETER_INVALID(ErrorCode.PARAMETER_INVALID, "参数校验错误"),

    private int code

    private String message

    private BusinessError(int code, String message) {
        this.code = code
        this.message = message
    }
}
