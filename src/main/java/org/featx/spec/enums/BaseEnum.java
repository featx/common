package org.featx.spec.enums;

/**
 * @author Excepts
 * @since 2020/8/30 3:31
 */
public interface BaseEnum {

    int getCode();

    String getMessage();

    default boolean equals(int code) {
        return code == getCode();
    }
}
