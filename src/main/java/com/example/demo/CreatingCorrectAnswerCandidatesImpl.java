package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
@lombok.AllArgsConstructor
public class CreatingCorrectAnswerCandidatesImpl implements CreatingCorrectAnswerCandidates {

    @Override
    public Integer[][] create(Integer[][] input, String[] HitBlow) {
        int i = 0;
        //使わない数字
        List<Integer> usedNumbers
                = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));

        //絞り込み
        while (i < HitBlow.length) {

            //一旦は総当たり
            //0H0B
            if (HitBlow[i].equals("0H0B")) {
                for (int j = 0; j < 3; j++) {
                    usedNumbers.remove(input[i][j]);
                }
            }

            //0H1B
            //0H2B
            //0H3B
            //1H0B
            //1H1B
            //1H2B
            //2H0B
            //2H1B

            i++;
        }

        //正解候補の出力
        ArrayList<ArrayList<Integer>> answerCandidates = new ArrayList<>();

        for (int a = 0; a < usedNumbers.size(); a++) {
            for (int b = 0; b < usedNumbers.size(); b++) {
                for (int c = 0; c < usedNumbers.size(); c++) {

                    answerCandidates.add(new ArrayList<>(Arrays.asList(usedNumbers.get(a), usedNumbers.get(b), usedNumbers.get(c))));
                }
            }
        }

        return answerCandidates.stream()
                .map(list -> list.toArray(Integer[]::new))
                .toList()
                .toArray(Integer[][]::new);
    }
}