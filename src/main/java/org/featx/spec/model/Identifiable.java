package org.featx.spec.model;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author Excepts
 * @since 2019/10/30 17:28
 */
public interface Identifiable<ID> extends Serializable {
    /**
     * get the id
     * @return the id
     */
    ID getId();

    /**
     * Is current data created or retrieved from somewhere
     * @return true for created, and false for retrieved.
     */
    default boolean isNew() {
        return Optional.ofNullable(getId()).isPresent();
    }
}
