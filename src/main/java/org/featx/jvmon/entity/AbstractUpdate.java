package org.featx.jvmon.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

/**
 * @author Excepts
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractUpdate<I> extends AbstractRecord<I> implements Update<I> {

    private LocalDateTime updatedAt;
}
