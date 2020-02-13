package org.featx.spec.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Excepts
 * @since 2019/12/31 13:50
 */
@Data
@NoArgsConstructor
public class FlowRequest {

    private String cursor;

    /**
     * Whether less than cursor or not, true for less than cursor , and false for not.
     */
    private Boolean desc;
}
