package org.featx.jvmon.entity;

import java.time.LocalDateTime;

/**
 * Some domain data structure which would be update
 * @author Excepts
 * @param <I>
 */
interface Update<I> extends Record<I> {
    /**
     * Get update  date time
     * @return the date time
     */
    LocalDateTime getUpdatedAt();
}
