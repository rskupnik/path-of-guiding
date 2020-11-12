package com.github.rskupnik.pog.core.domain;

import java.util.List;

public final class BuildDefinition {

    private final String name;
    private final List<Trigger> triggers;

    public BuildDefinition(String name, List<Trigger> triggers) {
        this.name = name;
        this.triggers = triggers;
    }

    public String getName() {
        return name;
    }

    public List<Trigger> getTriggers() {
        return triggers;
    }
}
