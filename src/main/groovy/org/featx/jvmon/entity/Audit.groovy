package org.featx.jvmon.entity

interface Audit<I> extends Update<I> {

    String getCreatedBy()

    String getUpdatedBy()
}
