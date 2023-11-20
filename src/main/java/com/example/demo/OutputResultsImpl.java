package com.example.demo;

import java.io.IOException;
import java.io.Reader;

@lombok.AllArgsConstructor
public class OutputResultsImpl implements OutputResults {
    /***************************
     * Hit/Blowの数、ロック解除であればその旨を表示する
     *
     *
     * *************************/

    private final HitAndBlowImpl hitAndBlow;

    @Override
    public void output(Reader read, char[] answer, int numDigit) throws IOException {

        hitAndBlow.hitAndBlow(read, answer, numDigit);

        System.out.println("**** UNLOCK!!! ***");

        System.out.println("* answer = [");
        for (int i = 0; i < numDigit; i++) {
            System.out.println(answer[i]);
        }
        System.out.println("] *\n");
    }
}
