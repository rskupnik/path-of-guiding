package com.github.rskupnik.pog.commons.triggers;

public abstract class Trigger {

    protected final String fullLine;

    public Trigger(String fullLine) {
        this.fullLine = fullLine;
    }

    public String getFullLine() {
        return fullLine;
    }
}