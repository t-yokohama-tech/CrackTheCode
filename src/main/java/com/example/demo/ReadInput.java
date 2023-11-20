package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public interface ReadInput {
    Reader read() throws IOException;
}
