package com.example.demo;

import java.io.InputStreamReader;
import java.io.Reader;

public class ReadInputImpl implements ReadInput{

    @Override
    public Reader read() {
        return new InputStreamReader(System.in);
    }
}
