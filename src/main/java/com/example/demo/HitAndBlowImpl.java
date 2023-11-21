package com.example.demo;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;

@Component
@lombok.AllArgsConstructor
public class HitAndBlowImpl implements HitAndBlow {

    private final CountHitImpl countHit;
    private final CountBlowImpl countBlow;

    @Override
    public String hitAndBlow(Integer[] answerCandidates, Integer[] input, int numDigit) {

        int numHit;
        int numBlow;
        String answerStr;
        numHit = countHit.countHit(answerCandidates, input, numDigit);
        numBlow = countBlow.countBlow(answerCandidates, input, numDigit);
        answerStr = numHit + "H" + numBlow + "B";

//        if (numHit == 0 && numBlow == 0) {
//            answerStr = "Nothing is correct!";
//        } else {
//            answerStr = numHit + "number correct!!  " + numBlow + "number correct, wrong place!!";
//        }
        return answerStr;
    }
}
