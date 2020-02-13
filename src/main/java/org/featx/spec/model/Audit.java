package org.featx.spec.model;
/**
 * Some domain data structure which would be update
 * @author Excepts
 * @param <I>
 * @since 2019/10/27 17:02
 */
public interface Audit<I> extends Update<I> {
    /**
     * get the creator user code
     * @return the creator user code
     */
    String getCreatedBy();
    /**
     * get the creator user code
     * @return the creator user code
     */
    String getUpdatedBy();
}
