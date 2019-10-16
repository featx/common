package org.featx.jvmon.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.featx.jvmon.exception.ErrorCode;

import java.util.List;

/**
 * @author Excepts
 * @since 2019/10/12 11:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FlowResponse<R> extends ListResponse<R> {

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

    public static <R> FlowResponse<R> succeeded(List<R> result)  {
        return new FlowResponse<>(ErrorCode.NO_ERROR, null, result);
    }
}
