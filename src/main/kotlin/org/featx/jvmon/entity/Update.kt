package org.featx.jvmon.entity

import java.time.LocalDateTime

interface Update<I> : Record<I> {
    val updatedAt: LocalDateTime?
}
