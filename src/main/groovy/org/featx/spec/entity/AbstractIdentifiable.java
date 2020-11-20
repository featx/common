package org.featx.spec.entity;

import lombok.Data;
import lombok.ToString;
import org.featx.spec.model.Identifiable;

import java.util.Optional;

/**
 * @author Excepts
 * @since 2019/10/27 17:12
 */
@Data
@ToString
public abstract class AbstractIdentifiable<I> implements Identifiable<I> {

    private static final long serialVersionUID = 708764700606035786L;

    private I id;

    private Boolean deleted;

    @Override
    public boolean isNew() {
        return Optional.ofNullable(id).isEmpty();
    }
}
