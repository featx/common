package org.featx.jvmon.entity

interface Identifiable<I> extends Serializable {

    I getId()

    Boolean isNew()

    Boolean getDeleted()
}
