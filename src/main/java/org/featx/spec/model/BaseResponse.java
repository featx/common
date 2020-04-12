package org.featx.spec.model;

import org.featx.spec.constant.ErrorCode;
import org.featx.spec.enums.BusinessError;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Excepts
 * @since 2019/10/27 10:03
 */
@Data
@NoArgsConstructor
public class BaseResponse<R> implements Serializable {

    private static final long serialVersionUID = 4996046788449418400L;
    /**
     * Error code in integer , which 0 express no-error
     */
    private int code = 0;
    /**
     * While code is not 0, some error message
     */
    private String message;
    /**
     * While no error, code = 0, the required response data structure.
     * While error, some other tips, guide data structure.
     */
    private R data;

    private BaseResponse(int code, String message, R data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <R> BaseResponse<R> succeeded(R result) {
        return new BaseResponse<>(ErrorCode.NO_ERROR, null, result);
    }

    public static <R> BaseResponse<R> with(R result) {
        return new BaseResponse<>(ErrorCode.NO_ERROR, null, result);
    }

    public static <R> BaseResponse<R> succeeded() {
        return new BaseResponse<>(ErrorCode.NO_ERROR, null, null);
    }

    public static <R> BaseResponse<R> occur(BusinessError businessError) {
        return new BaseResponse<>(businessError.getCode(), businessError.getMessage(), null);
    }

    public static <R> BaseResponse<R> occur(BusinessError businessError, R extra) {
        return new BaseResponse<>(businessError.getCode(), businessError.getMessage(), extra);
    }

    public static <R> BaseResponse<R> occur(int code, String message, R extra) {
        return new BaseResponse<>(code, message, extra);
    }
}