package com.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;


@Command
public class UtilStarter {

    public static void main(String[] args) {
        String commandIn = "-asp asd in1.txt in2.txt in3.txt int4.txt asdas";
        args = commandIn.split(" ");
        int exitCode = new CommandLine(new DataCollectorCommand()).execute(args);
        System.exit(exitCode);
    }
}
