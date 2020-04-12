package org.featx.spec.model;

import org.featx.spec.enums.QueryDirection;
import org.junit.jupiter.api.Test;

/**
 * @author Excepts
 * @since 2020/4/12 9:25
 */
public class EnumsTest {
    @Test
    public void test() {
        System.out.println(QueryDirection.valueOf("UP"));
    }
}
