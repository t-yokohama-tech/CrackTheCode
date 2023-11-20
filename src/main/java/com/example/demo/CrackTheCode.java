package com.example.demo;


import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.Reader;

@SpringBootApplication
@AllArgsConstructor
public class CrackTheCode implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrackTheCode.class, args);
    }

    private final BufferedReaderFactory bufferedReaderFactory;
    private final OutputResults outputResults;
    private final ShuffleAnswer shuffleAnswer;
    private final ReadInput readInput;
    private final int numDigit = 3;

    @Override
    public void run(String... args) throws IOException {
        try (Reader reader = bufferedReaderFactory.create(readInput.read())) {

            outputResults.output(reader,shuffleAnswer.shuffle(numDigit),numDigit);
        }
    }
}
