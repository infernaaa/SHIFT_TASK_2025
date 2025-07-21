package com.example;

import java.util.List;
import java.util.Map;

public class StatsGenerator {
    public void generate(Map<String, List<String>> data, ProcessingConfig config) {
        if (config.isShortStats()) {
            data.forEach((type, items) ->
                    System.out.printf("%s: %d items\n", type, items.size()));
        }

        if (config.isFullStats()) {

        }
    }
}
