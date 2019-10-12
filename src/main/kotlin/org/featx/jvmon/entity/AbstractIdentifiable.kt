package org.featx.jvmon.entity

import lombok.Data
import lombok.EqualsAndHashCode

import java.util.Optional

@Data
@EqualsAndHashCode(callSuper = true)
abstract class AbstractIdentifiable<I> : Identifiable<I> {
    override var id: I? = null
        set(id) {
            field = this.id
        }

    override var deleted: Boolean? = null
        set(deleted) {
            field = this.deleted
        }

    override val isNew: Boolean
        get() = Optional.ofNullable<I>(this.id).isPresent
}
