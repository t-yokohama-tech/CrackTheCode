package com.example.demo;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OneNumberCorrectWrongPlaceTest {

    private final OneNumberCorrectWrongPlace target = new OneNumberCorrectWrongPlace();

    @Nested
    class test {

        @Test
        void returnTrue() {
            var code = Code.from(7, 1, 8);

            var result = target.test(code);

            assertTrue(result);
        }

        @Test
        void returnFalse() {
            var code = Code.from(1, 1, 1);

            var result = target.test(code);

            assertFalse(result);
        }

        @Test
        void returnFalseSamePlaceNumber() {
            var code = Code.from(1, 1, 6);

            var result = target.test(code);

            assertFalse(result);
        }

        @Test
        void returnFalseSamePlaceNumber2() {
            var code = Code.from(6, 1, 1);

            var result = target.test(code);

            assertFalse(result);
        }

        @Test
        void returnFalseDuplicationNumber() {
            var code = Code.from(0, 8, 8);

            var result = target.test(code);

            assertFalse(result);
        }
    }
}
