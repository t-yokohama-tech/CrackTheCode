package com.example.demo;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class OneNumberCorrectWrongPlace implements Predicate<Code> {
    private final Code verifyNumber806 = Code.from(8, 0, 6);
    private final Code verifyNumber647 = Code.from(6, 4, 7);

    @Override
    public boolean test(Code code) {

        return  IntStream.range(0, Code.NUM_OF_DIGITS)
                .flatMap(i ->
                        IntStream.range(0, Code.NUM_OF_DIGITS)
                                .filter(j -> i != j )
                                .filter(j -> code.getDigit(i) == verifyNumber806.getDigit(j) || code.getDigit(i) == verifyNumber647.getDigit(j))
                ).count() == 2;
    }
}
