package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class Solver {

    public List<Integer> solve() {

        return Stream.iterate(0, n -> n + 1).limit(999)
                .filter(i -> {// 548 one number correct
                    OneNumberCorrectPredicate oneNumberCorrectPredicate = new OneNumberCorrectPredicate(Code.from(5, 4, 8));
                    return oneNumberCorrectPredicate.test(Code.from(IntToArray(i)));
                })
                .filter(i -> { // 530 nothing is correct
                    NothingIsCorrectPredicate nothingIsCorrectPredicate = new NothingIsCorrectPredicate(Code.from(5, 3, 0));
                    return nothingIsCorrectPredicate.test(Code.from(IntToArray(i)));
                })
                .filter(i -> {  // 157 2 number correct, wrong place
                    TwoNumberCorrectWrongPlace twoNumberCorrectWrongPlace = new TwoNumberCorrectWrongPlace(Code.from(1, 5, 7));
                    return twoNumberCorrectWrongPlace.test(Code.from(IntToArray(i)));
                })
                .filter(i -> { // 806 1 number correct, wrong place
                    OneNumberCorrectWrongPlace oneNumberCorrectWrongPlace = new OneNumberCorrectWrongPlace(Code.from(8, 0, 6));
                    return oneNumberCorrectWrongPlace.test(Code.from(IntToArray(i)));
                })
                .filter(i -> { // 647 1 number correct, wrong place
                    OneNumberCorrectWrongPlace oneNumberCorrectWrongPlace = new OneNumberCorrectWrongPlace(Code.from(6, 4, 7));
                    return oneNumberCorrectWrongPlace.test(Code.from(IntToArray(i)));
                })
                .toList();
    }


    private int[] IntToArray(int n) {

        int[] stack = new int[Code.NUM_OF_DIGITS];

        for (int i = Code.NUM_OF_DIGITS - 1; i > 0; i--) {
            stack[i] = n % 10;
            n = n / 10;
        }

        return stack;
    }

}
