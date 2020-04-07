package org.featx.spec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaTest {
    @Test
    public void test() {
        System.out.println( (180000L << 22) | (1 << 17) | (1 << 12) );
        System.out.println(Long.valueOf("zzzzzzzzzzzz", 36));
    }
}
