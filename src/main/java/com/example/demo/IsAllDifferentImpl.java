package com.example.demo;

public class IsAllDifferentImpl implements IsAllDifferent{

    /***************************
     * 入力された文字が重複していないかを判断する
     * inputStr[in]:入力された文字が格納された配列
     * len[in]:文字数
     * 返却値：1（全ての文字が重複していない場合）
     *      ：0（それ以外）
     * *************************/

    @Override
    public int is_allDifferent(char[] inputStr, int len) {

        for(int i = 0; i< len; i++) {
            for(int j= i+1; j<len; j++ ) {
                if(inputStr[i] == inputStr[j]){
                    return 0;
                }
            }
        }
        return 1;
    }
}
