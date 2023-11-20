package com.example.demo;

public class IsAllDigitImpl implements IsAllDigit{

    /***************************
     * 入力された文字が全て数字であるかを判断する
     * input[in]:入力された文字が格納された配列
     * len[in]:文字数
     * 返却値：1（全ての文字が数字である場合）
     *      ：0（それ以外）
     * *************************/

    @Override
    public int is_allDigit(char[] inputStr) {
        for (char c : inputStr) {
            if (!Character.isDigit(c)) {//数字以外の文字が入力されていないか
                return 0;
            }
        }
        return 1;
    }
}
