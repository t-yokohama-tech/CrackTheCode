package com.example.demo;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class NothingIsCorrectPredicate implements Predicate<Code> {

    private final Code verifyNumber;

    NothingIsCorrectPredicate(Code vCode){
        verifyNumber = vCode;
    }

    @Override
    public boolean test(Code code) {

        return IntStream.range(0, Code.NUM_OF_DIGITS)
                .allMatch(i ->code.getDigit(i) != verifyNumber.getDigit(i));
    }
}
