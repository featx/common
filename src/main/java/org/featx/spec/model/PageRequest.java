package org.featx.spec.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author Excepts
 * @since 2019-11-12 20:55
 **/

@Data
@NoArgsConstructor
public class PageRequest implements Serializable {

    private static final long serialVersionUID = 6020991498899573904L;

    private Integer page;

    private Integer size;

    public Integer getOffset() {
        return Optional.ofNullable(page)
                .flatMap(p -> Optional.ofNullable(size))
                .map(s -> (page - 1) * size)
                .orElse(0);
    }

    public PageRequest correctProperties() {
        this.page = Optional.ofNullable(page).filter(p -> p > 0).orElse(1);
        this.size = Optional.ofNullable(size).filter(s -> s > 0).orElse(10);
        return this;
    }

}
