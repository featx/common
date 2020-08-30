package org.featx.spec.util;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Excepts
 * @since 2020/8/30 13:47
 */
public class OptionalUtil {
    private OptionalUtil() {

    }

    public static <O, R> R nullDefault(O o, Function<? super O, R> function, R d4tR) {
        return Optional.ofNullable(o).map(function).orElse(d4tR);
    }

    public static <O, R> R nullDefault(O o, Function<? super O, R> function, Supplier<R> rSupplier) {
        return Optional.ofNullable(o).map(function).orElseGet(rSupplier);
    }

    public static <O> boolean nullTrue(O o, Function<? super O, Boolean> function) {
        return nullDefault(o, function, true);
    }

    public static <O> boolean nullFalse(O o, Function<? super O, Boolean> function) {
        return nullDefault(o, function, false);
    }
}
