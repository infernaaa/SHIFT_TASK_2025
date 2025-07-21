package com.example;

import java.io.File;
import java.util.List;

public class ProcessingConfig {
    private final List<File> inputFiles;
    private final String outputPath;
    private final String filePrefix;
    private final boolean appendMode;
    private final boolean shortStats;
    private final boolean fullStats;

    public ProcessingConfig(List<File> inputFiles, String outputPath, String filePrefix, boolean appendMode, boolean shortStats, boolean fullStats) {
        this.inputFiles = inputFiles;
        this.outputPath = outputPath;
        this.filePrefix = filePrefix;
        this.appendMode = appendMode;
        this.shortStats = shortStats;
        this.fullStats = fullStats;
    }

    public List<File> getInputFiles() {
        return inputFiles;
    }

    public boolean isFullStats() {
        return fullStats;
    }

    public boolean isShortStats() {
        return shortStats;
    }

    public boolean isAppendMode() {
        return appendMode;
    }

    public String getFilePrefix() {
        return filePrefix;
    }

    public String getOutputPath() {
        return outputPath;
    }
}
