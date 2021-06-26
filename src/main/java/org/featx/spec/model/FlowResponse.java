package org.featx.spec.model;

import org.featx.spec.constant.ErrorCode;
import org.featx.spec.enums.BusinessError;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Excepts
 * @since 2019/10/27 11:14
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FlowResponse<R> extends ListResponse<R> {

    private static final long serialVersionUID = -94683816577448812L;

    private Long total;

    private String previous;

    private String next;

    private FlowResponse(int code, String message, List<R> result) {
        this.setCode(code);
        this.setMessage(message);
        this.setResult(result);
    }

    public FlowResponse<R> previous(String previous) {
        this.previous = previous;
        return this;
    }

    public FlowResponse<R> next(String next) {
        this.next = next;
        return this;
    }

    public FlowResponse<R> cursor(String previous, String next) {
        this.previous = previous;
        this.next = next;
        return this;
    }

    public FlowResponse<R> total(Long total) {
        this.total = total;
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> FlowResponse<T> ofList(Class<T> returnType) {
        return (FlowResponse<T>) this;
    }

    public static <R> FlowResponse<R> succeeded(List<R> result) {
        return new FlowResponse<>(ErrorCode.NO_ERROR, null, result);
    }

    public static <R> FlowResponse<R> occur(BusinessError businessError, List<R> extra) {
        return new FlowResponse<>(businessError.getCode(), businessError.getMessage(), extra);
    }
}
