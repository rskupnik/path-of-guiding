package com.github.rskupnik.pog.buildloader.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LevelTriggerDef extends TriggerDef {

    private final int level;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public LevelTriggerDef(@JsonProperty("type") String type,
                           @JsonProperty("message") String message,
                           @JsonProperty("level") int level) {
        super(type, message);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
