package org.featx.spec.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.featx.spec.model.Update;

import java.time.LocalDateTime;

/**
 * @author Excepts
 * @since 2019/10/27 17:30
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class AbstractUpdate<I> extends AbstractRecord<I> implements Update {

    private static final long serialVersionUID = 2738637486289272752L;

    private LocalDateTime updatedAt;
}
