package com.example.demo;

import java.util.*;

public class ShuffleAnswerImpl implements ShuffleAnswer {

    /***************************
     * 数字の並びをシャッフルし、正解とする
     * numbers[in,out]:数字が格納される配列
     * numDigit[in]:数字の枚数
     * *************************/

    @Override
    public char[] shuffle(int numDigit) {

        char[] answer = new char[]{};
        char[] numbers = new char[]{
                '0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9'};
        List<Character> numbersList = new ArrayList<>();

        Collections.shuffle(numbersList);

        System.arraycopy(numbers, 0, answer, 0, numDigit);
        return answer;
    }
}
