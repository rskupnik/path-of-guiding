package com.github.rskupnik.pog.core.domain;

public abstract class TriggerInstance {

    private final TriggerType type;

    public TriggerInstance(TriggerType type) {
        this.type = type;
    }

    public TriggerType getType() {
        return type;
    }
}
