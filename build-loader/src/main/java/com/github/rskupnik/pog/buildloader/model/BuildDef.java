package com.github.rskupnik.pog.buildloader.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BuildDef {

    private final String name;
    private final List<TriggerDef> triggers;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BuildDef(@JsonProperty("name") String name,
                    @JsonProperty("triggers") List<TriggerDef> triggers) {
        this.name = name;
        this.triggers = triggers;
    }

    public String getName() {
        return name;
    }

    public List<TriggerDef> getTriggers() {
        return triggers;
    }
}
