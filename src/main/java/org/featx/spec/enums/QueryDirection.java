package org.featx.spec.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Excepts
 * @since 2020/4/11 23:42
 */
@Getter
public enum QueryDirection {

    UP(0, "up"),
    DOWN(1, "down"),
    ;

    private final int code;

    private String value;

    QueryDirection(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public boolean codeEquals(int code) {
        return Objects.equals(code, this.code);
    }

    public static QueryDirection of(int code) {
        return Arrays.stream(QueryDirection.values())
                .filter(e -> Objects.equals(e.code, code))
                .findFirst()
                .orElse(DOWN);
    }
}
