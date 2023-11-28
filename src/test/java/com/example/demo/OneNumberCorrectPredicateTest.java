package com.example.demo;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OneNumberCorrectPredicateTest {

    private final Code code548 = Code.from(5, 4, 8);

    private final OneNumberCorrectPredicate target = new OneNumberCorrectPredicate(code548);

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
