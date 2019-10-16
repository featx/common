package org.featx.jvmon.entity

import java.time.LocalDateTime

interface Record<I> extends Identifiable<I> {
    LocalDateTime getCreatedAt()
}
