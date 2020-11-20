package org.featx.spec.constant;

/**
 * @author Excepts
 * @since 2019/10/27 11:48
 */
public class ErrorCode {

    public static final Integer NO_ERROR = 1511200;
    /**
     * Lost Parameter
     */
    public static final Integer PARAMETER_LOST = 4000010;
    /**
     * Parameter type error
     */
    public static final Integer PARAMETER_TYPE = 4000011;
    /**
     * Parameter valid error
     */
    public static final Integer PARAMETER_INVALID = 4000012;
    /**
     * The api method required authorized
     */
    public static final Integer UNAUTHORIZED = 4010000;
    /**
     * The authorization credential error. e.g. username, and password not matched
     */
    public static final Integer UNAUTHORIZED_CREDENTIAL = 4010001;
    /**
     * The authorization access token expired
     */
    public static final Integer UNAUTHORIZED_TOKEN_EXPIRED = 4010002;
    /**
     * Not permit to access the resource
     */
    public static final Integer PERMISSION_DENIED = 4030000;
    /**
     * Not found
     */
    public static final Integer NOT_FOUND = 4040000;
    /**
     * Duplicated key, resource id existed
     */
    public static final Integer DUPLICATED_KEY = 4090000;
    /**
     * SERVER_ERROR
     */
    public static final Integer SERVER_ERROR = 5000000;
    /**
     * RPC error.
     */
    public static final Integer SERVER_REMOTE_PROCEDURE_CALL = 5000001;
}
