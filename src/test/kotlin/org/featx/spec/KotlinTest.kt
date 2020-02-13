package org.featx.spec

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KotlinTest {
    @Test
    fun test() {
        Assertions.assertEquals(-0x80000000, Integer.MIN_VALUE);
    }
}