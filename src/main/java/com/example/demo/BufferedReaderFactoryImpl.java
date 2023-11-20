package com.example.demo;

import java.io.BufferedReader;
import java.io.Reader;

public class BufferedReaderFactoryImpl implements BufferedReaderFactory {

    @Override
    public BufferedReader create(Reader reader){
        return new BufferedReader(reader);
    }
}
