package org.featx.spec.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.featx.spec.exception.ErrorCode;

import java.util.List;
import java.util.Optional;

/**
 * @author Excepts
 * @since 2019/10/12 11:01
 */
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ListResponse<R> extends BaseResponse<List<R>> {

    private ListResponse(int code, String message, List<R> result) {
        this.setCode(code);
        this.setMessage(message);
        this.setResult(result);
    }

    public Integer getSize() {
        return Optional.ofNullable(getResult()).map(List::size).orElse(0);
    }

    public static <R> BaseResponse<List<R>> succeeded(List<R> result) {
        return new ListResponse<>(ErrorCode.NO_ERROR, null, result);
    }
}