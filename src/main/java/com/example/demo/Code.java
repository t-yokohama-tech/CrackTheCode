package com.example.demo;


import java.util.Arrays;

@lombok.EqualsAndHashCode
@lombok.ToString
public class Code {

    private final int[] digits;
    public static final int NUM_OF_DIGITS = 3;

    public int getDigit(int position) {
        return this.digits[position];
    }

    public static Code from(int[] digits) {
        return new Code(digits);
    }

    public static Code from( int d2, int d1, int d0 ) {
        return new Code( new int[]{ d2, d1, d0 } );
    }

    /**
     * 暗証番号中が digit を含むとき true を返す.
     *
     * @param digit 探索する数
     * @return 暗証番号中が digit を含むとき true
     */
    public boolean contains(int digit) {

        return Arrays.stream( this.digits ).anyMatch(d -> d == digit );

    }

    private Code(int[] digits) {
        this.digits = digits.clone();
    }
}
