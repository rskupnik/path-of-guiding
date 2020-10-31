package com.github.rskupnik.pog.infrastructure;

import com.github.rskupnik.pog.build.JsonBuildLoader;
import com.github.rskupnik.pog.core.ports.BuildLoader;
import com.google.inject.AbstractModule;

public class PogModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(BuildLoader.class).to(JsonBuildLoader.class);
    }
}
