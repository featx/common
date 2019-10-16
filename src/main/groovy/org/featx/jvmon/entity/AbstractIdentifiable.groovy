package org.featx.jvmon.entity

import lombok.Data
import lombok.EqualsAndHashCode

@Data
@EqualsAndHashCode(callSuper = true)
abstract class AbstractIdentifiable<I> implements Identifiable<I> {
    private I id

    private Boolean deleted

    Boolean isNew() {
        return !Optional.of(id).isPresent()
    }
}
