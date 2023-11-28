package com.example.demo;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class OneNumberCorrectPredicate implements Predicate<Code> {

    private final Code verifyNumber;

    public OneNumberCorrectPredicate(Code vCode){
        verifyNumber = vCode;
    }

    @Override
    public boolean test(Code code) {

        return IntStream.range(0,Code.NUM_OF_DIGITS)
                .filter(i -> code.getDigit(i) == verifyNumber.getDigit(i))
                .count() == 1;
    }
}
