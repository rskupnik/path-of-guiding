package com.github.rskupnik.pog;

import com.github.rskupnik.pog.core.PathOfGuiding;
import com.github.rskupnik.pog.infrastructure.PogModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class POGApp {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PogModule());
        PathOfGuiding pog = injector.getInstance(PathOfGuiding.class);
        pog.start();
    }
}
