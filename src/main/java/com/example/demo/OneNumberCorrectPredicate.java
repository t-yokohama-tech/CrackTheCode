package com.example.demo;

import java.util.function.Predicate;

public class OneNumberCorrectPredicate implements Predicate<Code> {

    @Override
    public boolean test(Code code) {
        int trueNum = 1;
        int trueCount = 0;
        Code verifyNumber = Code.from(5, 4, 8);
        for (int i = 0; i < Code.NUM_OF_DIGITS; i++) {
            if (verifyNumber.getDigit(i) == code.getDigit(i)) trueCount++;
        }
        return trueCount == trueNum;
    }
}
