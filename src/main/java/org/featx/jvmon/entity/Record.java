package org.featx.jvmon.entity;

import java.time.LocalDateTime;

/**
 * Some log-type data which would not be updated, such as event.
 * @author Excepts
 */
public interface Record<I> extends Identifiable<I> {
    /**
     * Get the data time of this record
     * @return the record's datetime
     */
    LocalDateTime getCreatedAt();
}
