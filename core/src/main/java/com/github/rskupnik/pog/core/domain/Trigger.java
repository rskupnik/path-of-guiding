package com.github.rskupnik.pog.core.domain;

public abstract class Trigger {

    private final TriggerType type;
    private final String message;

    public Trigger(TriggerType type, String message) {
        this.type = type;
        this.message = message;
    }

    public TriggerType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public abstract static class Builder {

        protected TriggerType type;
        protected String message;

        protected Builder() {}

        public Builder ofType(TriggerType type) {
            this.type = type;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public abstract Trigger build();
    }
}
