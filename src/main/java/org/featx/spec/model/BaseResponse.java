package org.featx.spec.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.featx.spec.exception.BusinessError;
import org.featx.spec.exception.ErrorCode;

/**
 * @author Excepts
 * @since 2019/10/12 10:03
 */
@Data
@NoArgsConstructor
public class BaseResponse<R> {
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
    private R result;

    private BaseResponse(int code, String message, R result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public static <R> BaseResponse<R> succeeded(R result) {
        return new BaseResponse<>(ErrorCode.NO_ERROR, null, result);
    }

    public static <R> BaseResponse<R> occur(BusinessError businessError) {
        return new BaseResponse<>(businessError.getCode(), businessError.getMessage(), null);
    }

    public static <R> BaseResponse<R> occur(BusinessError businessError, R extra) {
        return new BaseResponse<>(businessError.getCode(), businessError.getMessage(), extra);
    }
}