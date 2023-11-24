package com.example.demo;


import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@AllArgsConstructor
public class NumberSearch implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NumberSearch.class, args);
    }

    private final Solver solver;

    @Override
    public void run(String... args) {

        var answer = solver.solve();

        System.out.println("正解 :" + answer);
    }
}
