package com.example.demo;


import java.util.stream.Stream;

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

    /**
     * 暗証番号中が digit を含むとき true を返す.
     *
     * @param digit 探索する数
     * @return 暗証番号中が digit を含むとき true
     */
    public boolean contains(int digit) {
        int i = 0;
        while (i < NUM_OF_DIGITS) {
            if (getDigit(i) == digit) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void Search() {

        var answerList = Stream.iterate(0, n -> n + 1).limit(999)
                .filter(i ->  // 548 one number correct
                        positionMatchVerification(IntToArray(i), new int[]{5, 4, 8}, 1)
                )
                .filter(i ->  // 530 nothing is correct
                        positionMatchVerification(IntToArray(i), new int[]{5, 3, 0}, 0)
                )
                .filter(i ->  // 157 2 number correct, wrong place
                        comparativeContainsVerification(IntToArray(i), new int[]{1, 5, 7}, 2)
                )
                .filter(i -> // 806 1 number correct, wrong place
                        comparativeContainsVerification(IntToArray(i), new int[]{8, 0, 6}, 1)
                )
                .filter(i ->  // 647 1 number correct, wrong place
                        comparativeContainsVerification(IntToArray(i), new int[]{6, 4, 7}, 1)
                )
                .toList();

        System.out.print(answerList);

    }

    private boolean positionMatchVerification(int[] answerCodeCandidates, int[] verifyNumber, int trueNum) {
        int trueCount = 0;
        for (int i = 0; i < NUM_OF_DIGITS; i++) {
            if (answerCodeCandidates[i] == verifyNumber[i]) {
                trueCount++;
            }
        }
        return trueCount == trueNum;
    }

    private boolean comparativeContainsVerification(int[] answerCodeCandidates, int[] verifyNumber, int trueNum) {
        from(answerCodeCandidates);//Codeに回答候補をセット //{0,0,0} ~ {9,9,9}
        int trueCount = 0;
        for (int i = 0; i < NUM_OF_DIGITS; i++) {
            if(contains(verifyNumber[i])) trueCount++;
        }
        return trueCount == trueNum;
    }

    private Code(int[] digits) {
        this.digits = digits.clone();
    }

    private int[] IntToArray(int n) {
        int i = 0;
        int[] stack = new int[NUM_OF_DIGITS];

        while (n > 0) {
            stack[i] = n % 10;
            n=n/10;
            i++;
        }

        return stack;
    }


}
