package com.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;


@Command
public class UtilStarter {

    public static void main(String[] args) {
        int exitCode = new CommandLine(new DataCollectorCommand()).execute(args);
        System.exit(exitCode);
    }
}
