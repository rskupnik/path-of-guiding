package com.github.rskupnik.pog.core.domain;

public final class LevelTrigger extends Trigger {

    private final int level;

    public LevelTrigger(TriggerType type, String message, int level) {
        super(type, message);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public static class Builder extends Trigger.Builder {

        private int level;

        private Builder() {}

        public Builder forLevel(int level) {
            this.level = level;
            return this;
        }

        @Override
        public LevelTrigger build() {
            return new LevelTrigger(type, message, level);
        }

        public static Builder create() {
            return new Builder();
        }
    }
}
