package com.example;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

@Command(name = "DataCollect", mixinStandardHelpOptions = true, version = "DataCollect 1.0",
        description = "Утилита фильтрации содержимого файлов")
public class DataParser implements Callable<Integer> {

    @Parameters(index = "..", description = "Имена файлов")
    private List<File> dataFiles;

    @Option(names = {"-o", "--onPath"}, description = "Задать путь к полученным файлам", defaultValue = "")
    private String destinationPath;

    @Option(names = {"-p", "--prefix"}, description = "Добавить префикс в созданные файлы", defaultValue = "")
    private String filePrefix;

    @Option(names = "-a", description = "Добавить результат в уже созданные файлы, если таковые имеются", defaultValue = "false")
    private Boolean isRewriteFile;

    @Option(names = "-s", description = "Добавить полную статистику", defaultValue = "false")
    private Boolean isShortStats;

    @Option(names = "-f", description = "Добавить полную статистику", defaultValue = "false")
    private Boolean isFullStats;


    @Override
    public Integer call() {
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
            DataFilter test = new DataFilter(allLines, destinationPath, filePrefix, isRewriteFile, isShortStats, isFullStats);
            System.out.print(allLines);
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }

//        System.out.println(destinationPath + " isStandardPath");
//        System.out.println(filePrefix + " isPrefix");
//        System.out.println(isRewriteFile + " isRewriteFile");
//        System.out.println(isShortStats + " isShortStats");
//        System.out.println(isFullStats + " isFullStats");
//        System.out.print(dataFiles);
        return 0;
    }

    public List<File> getDataFiles() {
        return dataFiles;
    }

    public void setDataFiles(List<File> dataFiles) {
        this.dataFiles = dataFiles;
    }

    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    public void setRewriteFile(Boolean rewriteFile) {
        isRewriteFile = rewriteFile;
    }

    public void setFilePrefix(String filePrefix) {
        this.filePrefix = filePrefix;
    }

    public void setShortStats(Boolean shortStats) {
        isShortStats = shortStats;
    }

    public void setFullStats(Boolean fullStats) {
        isFullStats = fullStats;
    }
}
