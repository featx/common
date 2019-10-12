package org.featx.jvmon.entity

import java.io.Serializable

interface Identifiable<I> : Serializable {

    val id: I?

    val isNew: Boolean?

    val deleted: Boolean?
}
