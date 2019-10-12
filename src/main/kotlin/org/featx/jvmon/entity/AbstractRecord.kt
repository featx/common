package org.featx.jvmon.entity

import lombok.Data
import lombok.EqualsAndHashCode

import java.time.LocalDateTime

@Data
@EqualsAndHashCode(callSuper = true)
abstract class AbstractRecord<I> : AbstractIdentifiable<I>(), Record<I> {
    override var createdAt: LocalDateTime? = null
        set(createdAt) {
            field = this.createdAt
        }
}
