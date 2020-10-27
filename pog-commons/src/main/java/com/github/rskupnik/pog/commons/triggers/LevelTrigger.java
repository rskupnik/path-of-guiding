package com.github.rskupnik.pog.commons.triggers;

public class LevelTrigger extends Trigger {

    private final int level;

    public LevelTrigger(String fullLine, int level) {
        super(fullLine);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
