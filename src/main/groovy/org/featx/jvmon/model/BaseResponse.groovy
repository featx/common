package org.featx.jvmon.model

import lombok.Data
import lombok.NoArgsConstructor
import org.featx.jvmon.exception.BusinessError
import org.featx.jvmon.exception.ErrorCode

/**
 * @author Excepts* @since 2019/10/12 10:03
 */
@Data
@NoArgsConstructor
public class BaseResponse<R> {
    /**
     * 错误码 0 为成功
     */
    private Integer code
    /**
     * code不为0时，错误说明
     */
    private String msg
    /**
     *
     */
    private R result

    BaseResponse<R> succeeded(R result) {
        return BaseResponse(ErrorCode.NO_ERROR, null, result)
    }

    BaseResponse<R> occur(BusinessError businessError) {
        return BaseResponse(businessError.code, businessError.message, null)
    }

    BaseResponse<R> occur(BusinessError businessError, R extra) {
        return BaseResponse(businessError.code, businessError.message, extra)
    }
}