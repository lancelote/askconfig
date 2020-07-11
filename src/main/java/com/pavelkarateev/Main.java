package com.pavelkarateev;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static final String HOME = System.getProperty("user.home");
    public static final String APPS = HOME + "/Library/Application Support/JetBrains/Toolbox/apps";

    static String trimPath(String file) {
        return file.replaceFirst(String.format("^%s/", APPS), "");
    }

    static void logStatus(String file, String status) {
        System.out.printf("%-65s %s%n", trimPath(file), status);
    }

    static void patchFile(Path path) {
        String file = String.valueOf(path);
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    if (line.equals("-Didea.initially.ask.config=true")) {
                        logStatus(file, "OK");
                        return;
                    }
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.append("\n-Didea.initially.ask.config=true");
                logStatus(file, "PATCHED");
            }
        } catch (IOException e) {
            System.out.println("failed to read " + file);
        }
    }

    public static void main(String[] args) {
        try {
            Files.walk(Paths.get(APPS), 4)
                    .filter((file) -> file.toString().endsWith(".vmoptions"))
                    .forEach(Main::patchFile);
        } catch (IOException e) {
            System.out.println("no toolbox apps were found");
        }
    }
}
