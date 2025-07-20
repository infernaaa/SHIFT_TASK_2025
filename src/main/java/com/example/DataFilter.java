package com.example;

import java.util.List;

public class DataFilter {

    private List<String> dataFromFile;

    private String pathToResult;
    private String prefixFiles;
    private Boolean appendToFiles;
    private Boolean shortStats;
    private Boolean FullStats;

    DataFilter(List<String> dataFromFile, String pathToResult, String prefixFiles, Boolean appendToFiles,
               Boolean shortStats, Boolean FullStats) {
        this.dataFromFile = dataFromFile;
        this.prefixFiles = prefixFiles;
        this.pathToResult = pathToResult;
        this.appendToFiles = appendToFiles;
        this.shortStats = shortStats;
        this.FullStats = FullStats;
    }

    public List<String> getDataFromFile() {
        return dataFromFile;
    }

    public void setDataFromFile(List<String> dataFromFile) {
        this.dataFromFile = dataFromFile;
    }

    public Boolean getFullStats() {
        return FullStats;
    }

    public void setFullStats(Boolean fullStats) {
        FullStats = fullStats;
    }

    public Boolean getShortStats() {
        return shortStats;
    }

    public void setShortStats(Boolean shortStats) {
        this.shortStats = shortStats;
    }

    public Boolean getAppendToFiles() {
        return appendToFiles;
    }

    public void setAppendToFiles(Boolean appendToFiles) {
        this.appendToFiles = appendToFiles;
    }

    public String getPrefixFiles() {
        return prefixFiles;
    }

    public void setPrefixFiles(String prefixFiles) {
        this.prefixFiles = prefixFiles;
    }

    public String getPathToResult() {
        return pathToResult;
    }

    public void setPathToResult(String pathToResult) {
        this.pathToResult = pathToResult;
    }
}



