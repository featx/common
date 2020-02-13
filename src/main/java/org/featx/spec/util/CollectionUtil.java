package org.featx.spec.util;

import java.util.Collection;
import java.util.Optional;

/**
 * @author Excepts
 * @since 2019/11/3 14:11
 */
public class CollectionUtil {

    private CollectionUtil () {

    }

    public static boolean isEmpty(Collection<?> collection) {
        return Optional.ofNullable(collection)
                .map(Collection::isEmpty)
                .orElse(true);
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}
