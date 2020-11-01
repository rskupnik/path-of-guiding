package com.github.rskupnik.pog.buildloader.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type"
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
}
