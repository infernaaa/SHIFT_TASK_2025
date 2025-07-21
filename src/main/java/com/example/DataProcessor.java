package com.example;

import java.util.List;
import java.util.Map;

public class DataProcessor {
    private final DataParser parser = new DataParser();
    private final DataFilter filter = new DataFilter();
    private final FileWriter writer = new FileWriter();
   // private final StatsGenerator stats = new StatsGenerator();

    public void process(ProcessingConfig config) {
        List<String> lines = parser.parse(config.getInputFiles());

        Map<String, List<String>> sortedData = filter.process(lines);

        writer.write(sortedData, config);

//        if (config.isShortStats() || config.isFullStats()) {
//            stats.generate(sortedData, config);
//        }
    }
}