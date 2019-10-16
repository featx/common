package org.featx.jvmon.entity;

import lombok.Data;
import java.util.Optional;

/**
 * @author Excepts
 */
@Data
public abstract class AbstractIdentifiable<I> implements Identifiable<I> {

    private I id;

    private Boolean deleted;

    @Override
    public Boolean isNew() {
        return !Optional.of(id).isPresent();
    }
}
