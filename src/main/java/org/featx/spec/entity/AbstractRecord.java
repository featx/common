package org.featx.spec.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
abstract class AbstractRecord<I> extends AbstractIdentifiable<I> implements Record<I> {

    private LocalDateTime createdAt;

}
