package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Solver {

    private final CodeStream codeStream = new CodeStream();

    public List<Code> solve() {
        return codeStream.iterate()
                .filter(i -> {// 548 one number correct
                    OneNumberCorrectPredicate oneNumberCorrectPredicate = new OneNumberCorrectPredicate(Code.from(5, 4, 8));
                    return oneNumberCorrectPredicate.test(i);
                })
                .filter(i -> { // 530 nothing is correct
                    NothingIsCorrectPredicate nothingIsCorrectPredicate = new NothingIsCorrectPredicate(Code.from(5, 3, 0));
                    return nothingIsCorrectPredicate.test(i);
                })
                .filter(i -> {  // 157 2 number correct, wrong place
                    TwoNumberCorrectWrongPlace twoNumberCorrectWrongPlace = new TwoNumberCorrectWrongPlace(Code.from(1, 5, 7));
                    return twoNumberCorrectWrongPlace.test(i);
                })
                .filter(i -> { // 806 1 number correct, wrong place
                    OneNumberCorrectWrongPlace oneNumberCorrectWrongPlace = new OneNumberCorrectWrongPlace(Code.from(8, 0, 6));
                    return oneNumberCorrectWrongPlace.test(i);
                })
                .filter(i -> { // 647 1 number correct, wrong place
                    OneNumberCorrectWrongPlace oneNumberCorrectWrongPlace = new OneNumberCorrectWrongPlace(Code.from(6, 4, 7));
                    return oneNumberCorrectWrongPlace.test(i);
                })
                .toList();
    }

}
