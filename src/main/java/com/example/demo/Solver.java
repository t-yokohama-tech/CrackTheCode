package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Solver {

    private final CodeStream codeStream = new CodeStream();

    public List<Code> solve() {
        return codeStream.iterate()
                .filter(new OneNumberCorrectPredicate(Code.from(5, 4, 8)))  // 548 one number correct
                .filter(new NothingIsCorrectPredicate(Code.from(5, 3, 0)))  // 530 nothing is correct
                .filter(new TwoNumberCorrectWrongPlace(Code.from(1, 5, 7))) // 157 2 number correct, wrong place
                .filter(new OneNumberCorrectWrongPlace(Code.from(8, 0, 6))) // 806 1 number correct, wrong place
                .filter(new OneNumberCorrectWrongPlace(Code.from(6, 4, 7))) // 647 1 number correct, wrong place
                .toList();
    }

}
