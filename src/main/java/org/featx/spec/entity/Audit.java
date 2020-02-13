package org.featx.spec.entity;

interface Audit<I> extends Update<I> {

    String getCreatedBy();

    String getUpdatedBy();
}
