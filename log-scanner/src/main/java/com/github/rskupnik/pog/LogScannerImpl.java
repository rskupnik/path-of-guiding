package com.github.rskupnik.pog;

import com.github.rskupnik.pog.core.domain.Trigger;
import com.github.rskupnik.pog.core.ports.LogScanner;
import io.vavr.control.Try;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class LogScannerImpl implements LogScanner {

    private boolean exit = false;
    private final BlockingQueue<Trigger> triggersQueue = new ArrayBlockingQueue<>(1024);

    public Try<Void> startScan(String poeFolder) {
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

        return Try.success(null);
    }

    public BlockingQueue<Trigger> getQueue() {
        return triggersQueue;
    }

    private void identifyTrigger(String line) {
        // TODO: Figure this out
    }
}
