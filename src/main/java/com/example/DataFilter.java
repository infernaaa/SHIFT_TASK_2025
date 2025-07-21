package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFilter {

    public Map<String, List<String>> process(List<String> data) {
        Map<String, List<String>> dataMap = new HashMap<>();
        List<String> integersList = new ArrayList<>();
        List<String> floatsList = new ArrayList<>();
        List<String> stringsList = new ArrayList<>();
        for (String item : data) {
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
        return dataMap;
    }

    private static boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;
        String numberRegex = "-?\\d+(\\.\\d+)?([eE][-+]?\\d+)?";
        return s.matches(numberRegex);
    }

    private static boolean isFloat(String s) {
        return s.contains(".") || s.toLowerCase().contains("e");
    }
}
