package org.featx.jvmon.entity

import lombok.Data
import lombok.EqualsAndHashCode

import java.time.LocalDateTime

@Data
@EqualsAndHashCode(callSuper = true)
abstract class AbstractUpdate<I> extends AbstractRecord<I> implements Update<I> {

    private LocalDateTime updatedAt
}
