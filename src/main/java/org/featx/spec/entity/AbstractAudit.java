package org.featx.spec.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.featx.spec.model.Audit;

/**
 * @author Excepts
 * @since 2019/10/27 17:02
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class AbstractAudit<I> extends AbstractUpdate<I> implements Audit<I> {

    private static final long serialVersionUID = -3410778135804720166L;

    private String createdBy;

    private String updatedBy;

}
