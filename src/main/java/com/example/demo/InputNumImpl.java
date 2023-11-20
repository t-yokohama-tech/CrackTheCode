package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

@lombok.AllArgsConstructor
public class InputNumImpl implements InputNum {
    /***************************
     * 数の入力を受け付ける
     * input[out]:入力された数が格納される配列
     * num_digit[in]:数の桁数
     * *************************/

    private final IsAllDifferentImpl isAllDifferent;
    private final IsAllDigitImpl isAllDigit;

    @Override
    public char[] input(Reader reader, int numDigit) throws IOException {

        System.out.printf("%d桁の数字を入力してください", numDigit);
        //   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(reader);
        String inputNum = in.readLine();
        char[] inputStr = inputNum.toCharArray();
        char[] input;
        while (true) {
            if (inputNum.length() != numDigit) {//桁数が合っているか
                System.out.println(numDigit + "桁を入力してください");
                continue;
            }


            if (isAllDigit.is_allDigit(inputStr) == 1) {//数字以外の文字が入力されていないか
                System.out.println("数字のみを入力してください");
                continue;
            }


            if (isAllDifferent.is_allDifferent(inputStr, 3) == 1) {//各行が重複していないか
                System.out.println("同じ数字が入力されています");
                continue;
            }

            input = inputNum.toCharArray();
            System.arraycopy(inputStr, 0, input, 0, numDigit);

            break;
        }
        return input;
    }
}
