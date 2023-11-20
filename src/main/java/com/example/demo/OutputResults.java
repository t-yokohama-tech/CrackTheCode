package com.example.demo;

import java.io.IOException;
import java.io.Reader;

public interface OutputResults {

    void output(Reader read, char[] answer, int numDigit) throws IOException;
}
