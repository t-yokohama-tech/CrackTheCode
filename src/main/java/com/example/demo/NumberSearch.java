package com.example.demo;


import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class NumberSearch implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NumberSearch.class, args);
    }

    private final HitAndBlow hitAndBlow;
    private final CreatingCorrectAnswerCandidates creatingCorrectAnswerCandidates;
    private final int numDigit = 3;

    @Override
    public void run(String... args) {
        int[][] input = {{5, 4, 8}, {5, 3, 0}, {1, 5, 7}, {8, 0, 6}, {6, 4, 7}};
        String[] HitBlow = {"1H0B", "0H0B", "2H0B", "0H1B", "0H1B"};

        //正解候補を絞り込む    一旦総当たり
        int[][] answerCandidates = creatingCorrectAnswerCandidates.create(input, HitBlow);
        int[][] answer = new int[0][];

        //正解候補とHitBlowの比較
        for (int i = 0; i < answerCandidates.length; i++) {
            for (int j = 0; j < input.length; j++) {
                String answerStr = hitAndBlow.hitAndBlow(answerCandidates[i], input[j], numDigit);

                System.out.print("検証した数字：" + input + "回答：" + answerStr);
                if (!answerStr.equals(HitBlow[i])) {
                    break;
                }
                //すべてHitBlow条件を満たす=正解
                answer[answer.length] = answerCandidates[i];
            }


        }


    }


}
