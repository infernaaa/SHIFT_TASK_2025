package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class DataParser {
    public List<String> parse(List<File> dataFiles) {
        try {
            List<String> allLines = dataFiles.stream()
                    .flatMap(file -> {
                        InputStream is = getClass().getClassLoader().getResourceAsStream(file.getName());
                        if (is == null) {
                            System.err.println("Ошибка в чтении файла: " + file.getName());
                            return Stream.empty();
                        }
                        return new BufferedReader(new InputStreamReader(is)).lines();
                    }).toList();
            return allLines;
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
        return List.of();
    }
}
