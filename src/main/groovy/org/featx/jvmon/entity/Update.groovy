package org.featx.jvmon.entity

import java.time.LocalDateTime

interface Update<I> extends Record<I> {
    LocalDateTime getUpdatedAt()
}
