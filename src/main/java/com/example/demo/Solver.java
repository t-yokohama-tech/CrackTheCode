package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class Solver {

    public List<Integer> solve() {

        return Stream.iterate(0, n -> n + 1).limit(999)
                .filter(i ->  // 548 one number correct
                        positionMatchVerification(Code.from(IntToArray(i)), Code.from(5,4,8), 1)
                )
                .filter(i ->  // 530 nothing is correct
                        positionMatchVerification(Code.from(IntToArray(i)), Code.from(5, 3, 0), 0)
                )
                .filter(i ->  // 157 2 number correct, wrong place
                        comparativeContainsVerification(Code.from(IntToArray(i)), Code.from(1, 5, 7), 2)
                )
                .filter(i -> // 806 1 number correct, wrong place
                        comparativeContainsVerification(Code.from(IntToArray(i)), Code.from(8, 0, 6), 1)
                )
                .filter(i ->  // 647 1 number correct, wrong place
                        comparativeContainsVerification(Code.from(IntToArray(i)), Code.from(6, 4, 7), 1)
                )
                .toList();
    }

    private boolean positionMatchVerification(Code answerCodeCandidates, Code verifyNumber, int trueNum) {
        int trueCount = 0;
        for (int i = 0; i < Code.NUM_OF_DIGITS; i++) {
            if (answerCodeCandidates.getDigit(i) == verifyNumber.getDigit(i)) trueCount++;
        }
        return trueCount == trueNum;
    }

    private boolean comparativeContainsVerification(Code answerCodeCandidates, Code verifyNumber, int trueNum) {
        int trueCount = 0;
        for (int i = 0; i < Code.NUM_OF_DIGITS; i++) {
            if(answerCodeCandidates.contains(verifyNumber.getDigit(i))) trueCount++;
        }
        return trueCount == trueNum;
    }


    private int[] IntToArray(int n) {

        int[] stack = new int[Code.NUM_OF_DIGITS];

        for(int i = Code.NUM_OF_DIGITS-1; i>0; i--){
            stack[i] = n % 10;
            n=n/10;
        }

        return stack;
    }

}
