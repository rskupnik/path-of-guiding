package com.github.rskupnik.pog.buildloader.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.rskupnik.pog.core.domain.BuildDefinition;

import java.util.List;
import java.util.stream.Collectors;

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

    public BuildDefinition toDefinition() {
        return new BuildDefinition(name, triggers.stream().map(TriggerDef::toDefinition).collect(Collectors.toList()));
    }
}
