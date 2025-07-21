package com.example;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

@Command(name = "DataCollect", mixinStandardHelpOptions = true, version = "DataCollect 1.0",
        description = "Утилита фильтрации содержимого файлов")
public class DataCollectorCommand implements Callable<Integer> {
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
        ProcessingConfig config = new ProcessingConfig(
                dataFiles,
                destinationPath,
                filePrefix,
                isRewriteFile,
                isShortStats,
                isFullStats
        );

        new DataProcessor().process(config);
        return 0;
    }
}
