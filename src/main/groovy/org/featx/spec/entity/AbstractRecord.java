package org.featx.spec.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.featx.spec.model.Record;

import java.time.LocalDateTime;

/**
 * @author Excepts
 * @since 2019/10/27 17:22
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class AbstractRecord<I> extends AbstractIdentifiable<I> implements Record {

    private static final long serialVersionUID = -63131834985445498L;

    private LocalDateTime createdAt;

}
