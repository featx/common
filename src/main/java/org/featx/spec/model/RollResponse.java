package org.featx.spec.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.featx.spec.constant.ErrorCode;
import org.featx.spec.enums.BusinessError;

import java.util.List;

/**
 * @author Excepts
 * @since 2020/4/11 23:39
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RollResponse<R> extends ListResponse<R> {
    private static final long serialVersionUID = -6772101723780407387L;

    private Long total;

    private String previous;

    private String next;

    private RollResponse(int code, String message, List<R> result) {
        this.setCode(code);
        this.setMessage(message);
        this.setResult(result);
    }

    public RollResponse<R> previous(String previous) {
        this.previous = previous;
        return this;
    }

    public RollResponse<R> next(String next) {
        this.next = next;
        return this;
    }

    public RollResponse<R> cursor(String previous, String next) {
        this.previous = previous;
        this.next = next;
        return this;
    }

    public RollResponse<R> total(Long total) {
        this.total = total;
        return this;
    }

    public static <R> RollResponse<R> succeeded(List<R> result) {
        return new RollResponse<>(ErrorCode.NO_ERROR, null, result);
    }

    public static <R> RollResponse<R> occur(BusinessError businessError, List<R> extra) {
        return new RollResponse<>(businessError.getCode(), businessError.getMessage(), extra);
    }
}
