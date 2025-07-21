package com.example;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

public class StatsGenerator {
    public void generate(Map<String, List<String>> data, ProcessingConfig config) {
        if (config.isShortStats()) {
            data.forEach((type, items) -> {
                if (!items.isEmpty()) {
                    System.out.printf("Записано %d элемента(ов) в файл: %s%n", items.size(), config.getFilePrefix()+type+".txt");
                }
            });
        }

        if (config.isFullStats()) {
            data.forEach((type, items) -> {
                if (!items.isEmpty()) {
                    switch (type) {
                        case "integer", "float" -> printNumberStats(type, items);
                        case "string" -> printStringStats(items);
                        default -> printBasicStats(type, items);
                    }
                    System.out.println();
                }
            });
        }

    }
    private void printNumberStats(String type, List<String> numberItems) {
        List<Double> numbers = numberItems.stream()
                .map(Double::parseDouble)
                .sorted()
                .toList();

        DoubleSummaryStatistics stats = numbers.stream()
                .mapToDouble(Double::doubleValue)
                .summaryStatistics();

        System.out.println("=== Числа (" + type + ") ===");
        System.out.println("Количество: " + stats.getCount());
        System.out.println("Минимальное: " + stats.getMin());
        System.out.println("Максимальное: " + stats.getMax());
        System.out.println("Сумма: " + stats.getSum());
        System.out.printf("Среднее: %.2f%n", stats.getAverage());
    }


    private void printStringStats(List<String> stringItems) {
        String shortest = stringItems.stream()
                .min(Comparator.comparingInt(String::length))
                .orElse("");

        String longest = stringItems.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        System.out.println("=== Строки ===");
        System.out.println("Количество: " + stringItems.size());
        System.out.println("Самая короткая (" + shortest.length() + " chars): " + shorten(shortest));
        System.out.println("Самая длинная (" + longest.length() + " chars): " + shorten(longest));
    }


    private void printBasicStats(String type, List<String> items) {
        System.out.println("=== " + type + " ===");
        System.out.println("Количество: " + items.size());
    }


    private String shorten(String str) {
        return str.length() > 50
                ? str.substring(0, 50) + "..."
                : str;
    }
}
