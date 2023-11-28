package com.example.demo;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class NothingIsCorrectPredicate implements Predicate<Code> {

    private final Code verifyNumber = Code.from(5, 3, 0);

    @Override
    public boolean test(Code code) {
return true;
      //  return IntStream.range(0,Code.NUM_OF_DIGITS)
//                .forEach(i -> code.getDigit(i))
//                .filter(i -> code.getDigit(i) == verifyNumber.getDigit(i))
//                .count() == 0;
    }
}
