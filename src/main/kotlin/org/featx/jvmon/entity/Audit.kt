package org.featx.jvmon.entity

interface Audit<I> : Update<I> {
    val createdBy: String?

    val updatedBy: String?
}
