package com.github.rskupnik.pog.infrastructure;

import com.github.rskupnik.pog.LogScannerImpl;
import com.github.rskupnik.pog.UIBoot;
import com.github.rskupnik.pog.buildloader.JsonBuildLoader;
import com.github.rskupnik.pog.core.ports.BuildLoader;
import com.github.rskupnik.pog.core.ports.LogScanner;
import com.github.rskupnik.pog.core.ports.UI;
import com.google.inject.AbstractModule;

public class PogModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(BuildLoader.class).to(JsonBuildLoader.class);
        bind(LogScanner.class).to(LogScannerImpl.class);
        bind(UI.class).to(UIBoot.class);
    }
}
