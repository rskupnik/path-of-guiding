package com.github.rskupnik.pog.buildloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rskupnik.pog.buildloader.model.BuildDef;
import com.github.rskupnik.pog.core.domain.BuildDefinition;
import com.github.rskupnik.pog.core.ports.BuildLoader;
import io.vavr.control.Either;

public class JsonBuildLoader implements BuildLoader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Either<Exception, BuildDefinition> load(String input) {
        try {
            return Either.right(objectMapper.readValue(input, BuildDef.class)); // TODO: Convert BuildDef (BuildJSON?) to BuildDefinition
        } catch (Exception e) {
            return Either.left(e);
        }
    }
}