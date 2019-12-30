package org.featx.jvmon.model;

/**
 * @author Excepts
 * @since 2019/12/20 19:45
 */
public interface Unified<I> extends Identifiable<I>, Named, Coded {
    /**
     *
     * @return The type value
     */
    Integer getType();
}
