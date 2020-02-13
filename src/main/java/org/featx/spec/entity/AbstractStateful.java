package org.featx.spec.entity;

import org.featx.spec.model.Stateful;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Excepts
 * @since 2020/1/4 10:46
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class AbstractStateful<I> extends AbstractUpdate<I> implements Stateful {

    private static final long serialVersionUID = 8472693481388368617L;

    private Integer status;
}
