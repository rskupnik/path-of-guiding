package com.github.rskupnik.pog.buildloader.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.rskupnik.pog.core.domain.LevelTrigger;
import com.github.rskupnik.pog.core.domain.Trigger;
import com.github.rskupnik.pog.core.domain.TriggerType;

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

    @Override
    public Trigger toDefinition() {
        return LevelTrigger.Builder.create()
                .forLevel(level)
                .ofType(TriggerType.fromString(getType()).getOrElseThrow(() -> new RuntimeException("Invalid Trigger type: " + getType())))
                .withMessage(getMessage())
                .build();
    }
}
