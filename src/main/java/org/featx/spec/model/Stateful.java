package org.featx.spec.model;

/**
 * @author Excepts
 * @since 2020/1/4 10:45
 */
public interface Stateful {

    /**
     * Get current state of a stateful object
     * @return status value in integer
     */
    Integer getStatus();
}
