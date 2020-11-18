package com.github.rskupnik.pog;

import com.github.rskupnik.pog.core.domain.LevelTriggerInstance;
import com.github.rskupnik.pog.core.domain.Trigger;
import com.github.rskupnik.pog.core.domain.TriggerInstance;
import com.github.rskupnik.pog.core.ports.LogScanner;
import io.vavr.control.Try;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogScannerImpl implements LogScanner {

    private final Map<Pattern, Function<Matcher, TriggerInstance>> regexes = new HashMap<>();

    private boolean exit = false;
    private final BlockingQueue<Trigger> triggersQueue = new ArrayBlockingQueue<>(1024);

    public LogScannerImpl() {
        regexes.put(Pattern.compile("is now level (\\d+)"), (m) -> new LevelTriggerInstance(Integer.parseInt(m.group(0))));
    }

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
        regexes.forEach((key, value) -> {
            var matcher = key.matcher(line);
            if (matcher.matches()) {
                value.apply(matcher);
            }
        });
    }
}
