package com.github.rskupnik.pog.buildloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rskupnik.pog.buildloader.model.BuildDef;
import com.github.rskupnik.pog.core.ports.BuildLoader;
import io.vavr.control.Either;

public class JsonBuildLoader implements BuildLoader {

    private static JsonBuildLoader INSTANCE;

    public static JsonBuildLoader getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new JsonBuildLoader();
        }

        return INSTANCE;
    }

    private final ObjectMapper objectMapper = new ObjectMapper();

    private JsonBuildLoader() {

    }

    public Either<Exception, BuildDef> load(String input) {
        try {
            return Either.right(objectMapper.readValue(input, BuildDef.class));
        } catch (Exception e) {
            return Either.left(e);
        }
    }
}