package com.example.demo;

import java.util.stream.Stream;

public class CodeStream {

    public Stream<Code> iterate() {
        Stream.Builder<Code> builder = Stream.builder();
        for (int i = 0; i < 1000; i++) {
            builder.add(Code.from(IntToArray(i)));
        }
        return builder.build();
    }

    private int[] IntToArray(int n) {

        int[] stack = new int[Code.NUM_OF_DIGITS];

        for (int i = Code.NUM_OF_DIGITS - 1; i > 0; i--) {
            stack[i] = n % 10;
            n = n / 10;
        }
        return stack;
    }
}
