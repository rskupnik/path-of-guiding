package com.github.rskupnik.pog.buildloader.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.rskupnik.pog.core.domain.Trigger;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = LevelTriggerDef.class, name = "level")
})
public abstract class TriggerDef {

    private final String type;
    private final String message;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public TriggerDef(@JsonProperty("type") String type,
                      @JsonProperty("message") String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public abstract Trigger toDefinition();
}
