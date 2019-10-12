package org.featx.jvmon.entity

import lombok.Data
import lombok.EqualsAndHashCode

@Data
@EqualsAndHashCode(callSuper = true)
abstract class AbstractAudit<I> : AbstractUpdate<I>(), Audit<I> {

    override var createdBy: String? = null
        set(id) {
            field = this.createdBy
        }

    override var updatedBy: String? = null
        set(deleted) {
            field = this.updatedBy
        }
}
