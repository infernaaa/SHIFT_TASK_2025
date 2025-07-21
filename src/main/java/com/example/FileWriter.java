package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileWriter {

    private final String INTEGER_FILE_NAME = "integer.txt";
    private final String FLOAT_FILE_NAME = "floats.txt";
    private final String STRING_FILE_NAME = "string.txt";

    public void fileWrite(HashMap<String, List<String>> dataMap,
                          String filePrefix, String filePath, Boolean appendToFile) {
        Path pathToFile;
        OpenOption[] strategy = appendToFile ? new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.APPEND}
                : new OpenOption[]{StandardOpenOption.CREATE};
        try {
            for (Map.Entry<String, List<String>> entry : dataMap.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                switch (key) {
                    case "integer":
                        pathToFile = Path.of(filePrefix + INTEGER_FILE_NAME);
                        break;
                    case "float":
                        pathToFile = Path.of(filePrefix + FLOAT_FILE_NAME);
                        break;
                    case "string":
                        pathToFile = Path.of(filePrefix + STRING_FILE_NAME);
                        break;
                    default:
                        continue;
                }
                Files.write(
                        pathToFile,
                        value,
                        strategy
                );
                System.out.println("Данные добавлены в файл: " + pathToFile);
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи: " + e.getMessage());
        }
    }
}




