package org.featx.spec.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Excepts
 * @since 2019/11/3 14:15
 */
@Data
@NoArgsConstructor
public class BaseUnified implements Unified {

    private static final long serialVersionUID = -3964309818124802874L;

    private String name;

    private String code;

    private Integer type;
}
