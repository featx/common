package org.featx.spec.model;

import java.io.Serializable;

/**
 * @author Excepts
 * @since 2020/1/2 23:06
 */

public interface Selectable extends Serializable {
    /**
     * Get code of this object
     * @return The code of this object
     */
    String getCode();
    /**
     * Get name of this object
     * @return The name of this object
     */
    String getName();
    /**
     * Get type of this object
     * @return The type of this object
     */
    String getDescription();
}
