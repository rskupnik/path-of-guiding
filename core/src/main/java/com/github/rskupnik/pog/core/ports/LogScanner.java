package com.github.rskupnik.pog.core.ports;

import com.github.rskupnik.pog.core.domain.Trigger;
import io.vavr.control.Try;

import java.util.concurrent.BlockingQueue;

public interface LogScanner {

    Try<Void> startScan(String folder);
    BlockingQueue<Trigger> getQueue();
}
