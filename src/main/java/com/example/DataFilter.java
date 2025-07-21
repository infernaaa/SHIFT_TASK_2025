package com.example;

import java.util.ArrayList;
import java.util.HashMap;
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

    public void dataSort() {
        HashMap<String, List<String>> dataMap = new HashMap<>();
        List<String> integersList = new ArrayList<>();
        List<String> floatsList = new ArrayList<>();
        List<String> stringsList = new ArrayList<>();
        for (String item : dataFromFile) {
            if (isNumber(item)) {
                if (isFloat(item)) {
                    floatsList.add(item);
                } else {
                    integersList.add(item);
                }
            } else {
                stringsList.add(item);
            }
        }
        dataMap.put("integer", integersList);
        dataMap.put("float", floatsList);
        dataMap.put("string", stringsList);
        FileWriter fileWriter = new FileWriter();
        fileWriter.fileWrite(dataMap, prefixFiles, pathToResult, appendToFiles);
    }

    private static boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;
        String numberRegex = "-?\\d+(\\.\\d+)?([eE][-+]?\\d+)?";
        return s.matches(numberRegex);
    }

    private static boolean isFloat(String s) {
        return s.contains(".") || s.toLowerCase().contains("e");
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



