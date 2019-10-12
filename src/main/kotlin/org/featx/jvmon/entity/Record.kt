package org.featx.jvmon.entity

import java.time.LocalDateTime

interface Record<I> : Identifiable<I> {
    val createdAt: LocalDateTime?
}
