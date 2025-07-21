package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

public class FileWriter {
    private final String INTEGER_FILE_NAME = "integer.txt";
    private final String FLOAT_FILE_NAME = "floats.txt";
    private final String STRING_FILE_NAME = "string.txt";

    public void write(Map<String, List<String>> data, ProcessingConfig config) {
        String path = config.getOutputPath();
        String prefix = config.getFilePrefix();

        OpenOption[] strategy = config.isAppendMode()
                ? new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.APPEND}
                : new OpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING};

        data.forEach((type, lines) -> {
            String filename = prefix + getFileName(type);
            Path filePath = path.isEmpty() ? Path.of(filename) : Path.of(path, filename);

            try {
                if (!lines.isEmpty()) {
                    Files.write(filePath, lines, strategy);
                    System.out.println("Данные добавлены в файл: " + filePath);
                }

            } catch (IOException e) {
                System.err.println("Ошибка записи в файл " + filename + ": " + e.getMessage());
            }
        });
    }

    private String getFileName(String type) {
        return switch (type) {
            case "integer" -> INTEGER_FILE_NAME;
            case "float" -> FLOAT_FILE_NAME;
            default -> STRING_FILE_NAME;
        };
    }
}
