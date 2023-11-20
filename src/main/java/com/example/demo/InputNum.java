package com.example.demo;

import java.io.IOException;
import java.io.Reader;

public interface InputNum {

    char[] input(Reader reader, int numDigit) throws IOException;
}
