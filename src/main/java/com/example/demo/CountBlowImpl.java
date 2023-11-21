package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class CountBlowImpl implements CountBlow {

    /***************************
     * Blow数を数える
     * input[in]:入力された数が格納された配列
     * answer[in]:正解の数が格納された配列
     * numDigit[in]:数の桁数
     * 返却値：Blow数
     * *************************/
    @Override
    public int countBlow(Integer[] input, Integer[] answer, int numDigit) {
        int numBlow = 0;

        for (int i = 0; i < numDigit; i++) {
            for (int j = 0; j < numDigit; j++) {
                if (answer[i].equals(input[j])) {
                    if (i != j) {
                        numBlow++;
                    }
                }
            }
        }
        return numBlow;
    }
}
