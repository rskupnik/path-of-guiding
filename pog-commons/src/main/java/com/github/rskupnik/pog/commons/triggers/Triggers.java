package com.github.rskupnik.pog.commons.triggers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Triggers {

    private static final List<TriggerFactory<? extends Trigger>> triggerFactories = new ArrayList<>();

    static {
        triggerFactories.add(new LevelTriggerFactory());
        triggerFactories.add(new AreaTriggerFactory());
    }

    private Triggers() {}

    public static Optional<Trigger> matchLine(String line) {
        for (TriggerFactory<? extends Trigger> triggerFactory : triggerFactories) {
            Optional<? extends Trigger> trigger = triggerFactory.match(line);
            if (trigger.isPresent())
                return Optional.of(trigger.get());
        }
        return Optional.empty();
    }
}
