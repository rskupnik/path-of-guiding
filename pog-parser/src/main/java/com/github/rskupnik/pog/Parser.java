package com.github.rskupnik.pog;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Parser {

    private static Parser INSTANCE;

    public static Parser getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Parser();
        }
        return INSTANCE;
    }

    private boolean exit = false;

    private Parser() {
        
    }

    public void startScanning(String poeFolder) {
        Executor executor = Executors.newSingleThreadExecutor();
        String fileLocation = poeFolder + "/logs/Client.txt";
        executor.execute(() -> {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileLocation))));

                while (!exit) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
