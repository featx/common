package org.featx.spec.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Excepts
 * @since 2020/4/12 10:49
 */
@Data
public class QueryResult<E> implements Serializable {

    private static final long serialVersionUID = -4256446448374984655L;

    private Collection<E> result;

    private Long total;

    public List<E> list() {
        if (result instanceof List) {
            return (List<E>) result;
        }
        return Lists.newArrayList(result);
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
