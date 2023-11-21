package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class CountHitImpl implements CountHit{

    /***************************
     * Hit数を数える
     * input[in]:入力された数が格納された配列
     * answer[in]:正解の数が格納された配列
     * numDigit[in]:数の桁数
     * 返却値：Hit数
     * *************************/

    @Override
    public int countHit(int[] input, int[] answer, int numDigit) {

        int numHit = 0;

        for(int i = 0; i<numDigit; i++) {
            for(int j= 0; j<numDigit; j++){
                if(answer[i] == input[j]) {
                    if(i == j){
                        numHit++;
                    }
                }
            }
        }
        return numHit;
    }
}
