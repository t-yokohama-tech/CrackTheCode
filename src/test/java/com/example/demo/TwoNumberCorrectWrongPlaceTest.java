package com.example.demo;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoNumberCorrectWrongPlaceTest {

    private final Code code =  Code.from(1, 5, 7);

    private final TwoNumberCorrectWrongPlace target = new TwoNumberCorrectWrongPlace(code);

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
            var code = Code.from(0, 1, 6);

            var result = target.test(code);

            assertFalse(result);
        }

        @Test
        void returnFalseSamePlaceNumber() {
            var code = Code.from(0, 1, 7);

            var result = target.test(code);

            assertFalse(result);
        }

        @Test
        void returnTrueDuplicationNumber() {
            var code = Code.from(0, 1, 1);

            var result = target.test(code);

            assertTrue(result);
        }
    }
}
