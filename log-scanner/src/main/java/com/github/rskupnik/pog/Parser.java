package com.github.rskupnik.pog;

import com.github.rskupnik.pog.commons.triggers.Trigger;
import com.github.rskupnik.pog.commons.triggers.Triggers;

import java.io.*;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
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
    private final BlockingQueue<Trigger> triggersQueue = new ArrayBlockingQueue<>(1024);

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
                        identifyTrigger(line);
                    }
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public BlockingQueue<Trigger> getTriggersQueue() {
        return triggersQueue;
    }

    private void identifyTrigger(String line) {
        Triggers.matchLine(line).ifPresent(t -> {
            try {
                triggersQueue.put(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
