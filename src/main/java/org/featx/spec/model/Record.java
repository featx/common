package org.featx.spec.model;

import java.time.LocalDateTime;

/**
 * @author Excepts
 * @since 2019/12/20 19:49
 */
public interface Record {
    /**
     * Date time of this/current record
     *
     * @return LocalDateTime The date-time of this record
     */
    LocalDateTime getCreatedAt();
}
