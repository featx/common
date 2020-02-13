package org.featx.spec.model;

import java.time.LocalDateTime;

/**
 * Some domain data structure which would be update
 * @author Excepts
 * @param <I>
 * @since 2019/10/27 17:02
 */
public interface Update<I> extends Record<I> {
    /**
     * Get update  date time
     * @return the date time
     */
    LocalDateTime getUpdatedAt();
}
