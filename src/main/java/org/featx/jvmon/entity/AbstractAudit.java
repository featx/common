package org.featx.jvmon.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Excepts
 * @since 2019/10/15 0:34
 */

@Data
@EqualsAndHashCode(callSuper = true)
abstract class AbstractAudit<I> extends AbstractUpdate<I> implements Audit<I> {

    private String createdBy;

    private String updatedBy;

}
