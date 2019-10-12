package org.featx.jvmon.entity

import lombok.Data
import lombok.EqualsAndHashCode

import java.time.LocalDateTime

@Data
@EqualsAndHashCode(callSuper = true)
abstract class AbstractUpdate<I> : AbstractRecord<I>(), Update<I> {

    override var updatedAt: LocalDateTime? = null
        set(updatedAt) {
            field = this.updatedAt
        }
}
