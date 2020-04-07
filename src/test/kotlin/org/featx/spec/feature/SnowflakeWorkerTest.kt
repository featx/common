package org.featx.spec.feature

import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.impl.annotations.SpyK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.LocalDateTime
import java.time.ZoneOffset
import kotlin.test.assertEquals

/**
 * @author Excepts
 * @since 2020/4/6 15:13
 */
@ExtendWith(MockKExtension::class)
class SnowflakeWorkerTest {
    @SpyK
    var snowflakeIdWorker = SnowflakeIdWorker(
            LocalDateTime.of(2020, 4, 4, 10, 0, 0).toInstant(ZoneOffset.UTC).toEpochMilli(),
            1L, 1L);

    //    1585965780000 - 1585965600000
    @Test
    fun testNextId() {
        val timestamp = LocalDateTime.of(2020, 4, 4, 10, 3, 0).toInstant(ZoneOffset.UTC).toEpochMilli()
        every { snowflakeIdWorker.tickNextMill() } returns timestamp;

        for (i in 0 until 96) {//4096
            assertEquals(754974855168L + i, snowflakeIdWorker.nextId())
            verify { snowflakeIdWorker.tickNextMill() }
        }
//        assertNotEquals(754974855168L + 4096L, snowflakeIdWorker.nextId())
        confirmVerified(snowflakeIdWorker)
    }
}
