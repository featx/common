package org.featx.spec.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Excepts
 * @since 2020/1/2 23:07
 */
@Data
@NoArgsConstructor
public class Selection implements Selectable {

    private static final long serialVersionUID = -3232926291223390688L;

    private String code;

    private String name;

    private String description;
}
