package org.featx.spec.model;

import org.featx.spec.constant.ErrorCode;
import org.featx.spec.enums.BusinessError;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

/**
 * @author Excepts
 * @since 2019/10/27 11:01
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ListResponse<R> extends BaseResponse<List<R>> {

    private static final long serialVersionUID = -1370862431440698540L;

    private ListResponse(int code, String message, List<R> result) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(result);
    }

    public Integer getSize() {
        return Optional.ofNullable(getData()).map(List::size).orElse(0);
    }

    public static <R> ListResponse<R> succeeded(List<R> result) {
        return new ListResponse<>(ErrorCode.NO_ERROR, null, result);
    }

    public static <R> ListResponse<R> occur(BusinessError businessError, List<R> extra) {
        return new ListResponse<R>(businessError.getCode(), businessError.getMessage(), extra);
    }
}