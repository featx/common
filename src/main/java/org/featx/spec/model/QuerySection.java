package org.featx.spec.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import lombok.Data;
import org.featx.spec.util.CollectionUtil;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Excepts
 * @since 2020/4/12 10:49
 */
@Data
public class QuerySection<E> implements Serializable {

    private static final long serialVersionUID = -4256446448374984655L;

    private Collection<E> result;

    private Long total;

    public static <T>QuerySection<T> of(Collection<T> collection) {
        QuerySection<T> querySection = new QuerySection<>();
        querySection.result = collection;
        return querySection;
    }

    public QuerySection<E> total(Long total) {
        this.total=total;
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T>QuerySection<T> convertAsList(final Function<E, T> converter) {
        return Optional.of(this.result).filter(CollectionUtil::isNotEmpty)
                .map(l->l.stream().map(converter).collect(Collectors.toList()))
                .map(QuerySection::of)
                // It's type safe while result is empty, so not to check
                .orElse((QuerySection<T>) this);

    }

    public List<E> list() {
        if (result instanceof List) {
            return (List<E>) result;
        }
        return Lists.newArrayList(result);
    }

    @SuppressWarnings("unchecked")
    public <T>QuerySection<T> convertAsSet(final Function<E, T> converter) {
        return Optional.of(this.result).filter(CollectionUtil::isNotEmpty)
                .map(l->l.stream().map(converter).collect(Collectors.toSet()))
                .map(QuerySection::of)
                // It's type safe while result is empty, so not to check
                .orElse((QuerySection<T>) this);

    }

    public Set<E> set() {
        if (result instanceof Set) {
            return (Set<E>) result;
        }
        return Sets.newHashSet(result);
    }

    public Queue<E> queue() {
        if (result instanceof Queue) {
            return (Queue<E>) result;
        }
        return Queues.newArrayDeque(result);
    }
}
