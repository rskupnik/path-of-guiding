package com.github.rskupnik.pog.core.domain;

public final class LevelTriggerInstance extends TriggerInstance {

    private final int level;

    public LevelTriggerInstance(int level) {
        super(TriggerType.LEVEL);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
