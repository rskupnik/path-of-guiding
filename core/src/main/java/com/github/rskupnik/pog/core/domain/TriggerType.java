package com.github.rskupnik.pog.core.domain;

import io.vavr.control.Option;

public enum TriggerType {
    LEVEL;

    public static Option<TriggerType> fromString(String type) {
        return switch (type.toUpperCase().trim()) {
            case "LEVEL" -> Option.of(LEVEL);
            default -> Option.none();
        };
    }
}
