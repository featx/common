package org.featx.spec.model;

import java.time.LocalDateTime;

/**
 * Some log-type data which would not be updated, such as event.
 * @author Excepts
 * @since 2019/10/27 17:01
 */
public interface Record {
    /**
     * Get the data time of this record
     * @return the record's datetime
     */
    LocalDateTime getCreatedAt();
}
