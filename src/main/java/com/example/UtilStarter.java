package com.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;


@Command
public class UtilStarter {

    public static void main(String[] args) {
        String commandIn = "-p hahahehe in1.txt in2.txt in3.txt";
        args = commandIn.split(" ");
        int exitCode = new CommandLine(new DataParser()).execute(args);
        System.exit(exitCode);
    }
}
