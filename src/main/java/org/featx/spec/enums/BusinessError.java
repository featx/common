package org.featx.spec.enums;

import org.featx.spec.constant.ErrorCode;
import lombok.Getter;

/**
 * @author Excepts
 * @since 2019/10/27 11:20
 */
@Getter
public enum BusinessError {
    /**
     * Parameter lost
     */
    PARAMETER_LOST(ErrorCode.PARAMETER_LOST, "Lost some parameter"),
    /**
     * Parameter type error
     */
    PARAMETER_TYPE(ErrorCode.PARAMETER_TYPE, "Parameter type error"),
    /**
     * Parameter invalid
     */
    PARAMETER_INVALID(ErrorCode.PARAMETER_INVALID, "Parameter error"),
    /**
     * Operation method required authorized
     */
    UNAUTHORIZED(ErrorCode.UNAUTHORIZED, "Operation method required authorized"),
    /**
     * Credential error
     */
    UNAUTHORIZED_CREDENTIAL(ErrorCode.UNAUTHORIZED_CREDENTIAL, "Credential error, maybe username password not matched"),
    /**
     * Token error or expired
     */
    UNAUTHORIZED_TOKEN_EXPIRED(ErrorCode.UNAUTHORIZED_TOKEN_EXPIRED, "Access token error or expired"),
    /**
     * Permission denied
    */
    PERMISSION_DENIED(ErrorCode.PERMISSION_DENIED, "Not allow to access the resource."),
    /**
     * Resource not found
     */
    NOT_FOUND(ErrorCode.NOT_FOUND, "Resource not found"),
    /**
     * Resource identity existed
     */
    DUPLICATED_KEY(ErrorCode.DUPLICATED_KEY, "Resource identity existed"),
    /**
     * Internal server error
     */
    SERVER_ERROR(ErrorCode.SERVER_ERROR, "server error"),
    /**
     *
     */
    SERVER_REMOTE_PROCEDURE_CALL(ErrorCode.SERVER_REMOTE_PROCEDURE_CALL, "Remote procedure call error"),


    ;
    private int code;

    private String message;

    BusinessError(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
