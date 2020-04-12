package org.featx.spec.model;

import java.time.LocalDateTime;

/**
 * Some domain data structure which would be update
 * @author Excepts
 * @param <I> The id type template
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

    default Audit<I> audit() {
        return new Audit<>() {
            @Override
            public String getCreatedBy() {
                return Audit.this.getCreatedBy();
            }

            @Override
            public String getUpdatedBy() {
                return Audit.this.getUpdatedBy();
            }

            @Override
            public LocalDateTime getUpdatedAt() {
                return Audit.this.getUpdatedAt();
            }

            @Override
            public LocalDateTime getCreatedAt() {
                return Audit.this.getCreatedAt();
            }

            @Override
            public I getId() {
                return Audit.this.getId();
            }
        };
    }
}
