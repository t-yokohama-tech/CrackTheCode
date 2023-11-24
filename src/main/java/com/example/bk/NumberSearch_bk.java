package com.example.bk;


import com.example.demo.Code;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@AllArgsConstructor
public class NumberSearch_bk implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Code.class, args);
        SpringApplication.run(NumberSearch_bk.class, args);
    }

    private final HitAndBlow hitAndBlow;
    private final CreatingCorrectAnswerCandidates creatingCorrectAnswerCandidates;
    private final int numDigit = 3;

    @Override
    public void run(String... args) {
        Integer[][] input = {{5, 4, 8}, {5, 3, 0}, {1, 5, 7}, {8, 0, 6}, {6, 4, 7}};
        String[] HitBlow = {"1H0B", "0H0B", "2H0B", "0H1B", "0H1B"};

        //正解候補を絞り込む    一旦総当たり
        Integer[][] answerCandidates = creatingCorrectAnswerCandidates.create(input, HitBlow);
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        //正解候補とHitBlowの比較
        for (int i = 0; i < answerCandidates.length; i++) {
            int k = 0;
            for (int j = 0; j < input.length; j++) {

                String answerStr = hitAndBlow.hitAndBlow(answerCandidates[i], input[j], numDigit);
                if (!answerStr.equals(HitBlow[j])) {
                    break;
                }
                k++;
                if (k == 4) {//すべてHitBlow条件を満たす=正解
                    answer.add(new ArrayList<>(Arrays.asList(answerCandidates[i])));
                }
            }
        }
        System.out.println("正解 :" + answer);
    }
}
