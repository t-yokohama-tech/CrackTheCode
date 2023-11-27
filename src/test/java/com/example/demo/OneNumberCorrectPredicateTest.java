package com.example.demo;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OneNumberCorrectPredicateTest {

    private final OneNumberCorrectPredicate target = new OneNumberCorrectPredicate();

    @Nested
    class test {

        @Test
        void returnTrue() {
            var code = Code.from(0, 0, 8);

            var result = target.test(code);

            assertTrue(result);
        }

        @Test
        void returnFalse() {
            var code = Code.from(0, 0, 0);

            var result = target.test(code);

            assertFalse(result);
        }
    }
}
