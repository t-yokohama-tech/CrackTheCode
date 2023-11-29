package com.example.demo;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodeStreamTest {

    private final CodeStream target = new CodeStream();

    @Nested
    class iterate {

        @Test
        void returnTrue() {
            var result = target.iterate();

            assertEquals(1000, result.count());
        }

        @Test
        void returnTrueContainsNumbersWithinBoundaries() {
            var result = target.iterate();
            var a = result.toList();
            System.out.println(a);
            assertTrue(a.contains(Code.from(0, 0, 0)));
            assertTrue(a.contains(Code.from(9, 9, 9)));
        }
    }
}