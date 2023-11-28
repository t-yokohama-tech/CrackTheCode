package com.example.demo;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NothingIsCorrectPredicateTest {

    private final NothingIsCorrectPredicate target = new NothingIsCorrectPredicate();

    @Nested
    class test {

        @Test
        void returnTrue(){
            var code = Code.from(1,2,3);

            var result = target.test(code);

            assertTrue(result);
        }

        @Test
        void returnTrueNoNumbersAppear(){
            var code = Code.from(9,9,9);

            var result = target.test(code);

            assertTrue(result);
        }

        @Test
        void returnFalse() {
            var code = Code.from(5, 0, 3);

            var result = target.test(code);

            assertFalse(result);
        }
    }
}
