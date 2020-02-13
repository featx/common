package org.featx.spec.util;

import java.util.Map;
import java.util.Optional;

/**
 * @author Excepts
 * @since 2019/11/3 14:11
 */
public class MapUtil {

    private MapUtil() {

    }

    public static boolean isEmpty(Map<?, ?> map) {
        return Optional.ofNullable(map).map(Map::isEmpty).orElse(true);
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
}
