package org.featx.spec.model;

import lombok.Data;
import org.featx.spec.enums.QueryDirection;

import java.io.Serializable;

/**
 * @author Excepts
 * @since 2020/4/11 23:38
 */
@Data
public class RollRequest implements Serializable {

    private static final long serialVersionUID = 4292759818056630348L;

    private String cursor;

    private QueryDirection direction;

    public void setDirection(int direction) {
        this.direction =  QueryDirection.of(direction);
    }

    public void setDirection(String string) {
        if("UP".equalsIgnoreCase(string)) {
            this.direction = QueryDirection.UP;
        } else {
            this.direction = QueryDirection.DOWN;
        }
    }
}
