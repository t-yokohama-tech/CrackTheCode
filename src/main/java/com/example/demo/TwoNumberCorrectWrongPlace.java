package com.example.demo;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class TwoNumberCorrectWrongPlace implements Predicate<Code> {

    private final Code verifyNumber;

    TwoNumberCorrectWrongPlace(Code vCode) {
        verifyNumber = vCode;
    }

    @Override
    public boolean test(Code code) {

        return noMatchOnSamePosition(code) && countMatchesOnAnyPosition(code) == 2;
    }

    private boolean noMatchOnSamePosition(Code code) {
        return IntStream.range(0, Code.NUM_OF_DIGITS)
                .allMatch(pos ->
                        verifyNumber.getDigit(pos) != code.getDigit(pos)
                );
    }

    private long countMatchesOnAnyPosition(Code code) {
        return IntStream.range(0, Code.NUM_OF_DIGITS)
                .map(verifyNumber::getDigit)
                .filter(code::contains)
                .count();
    }
}
