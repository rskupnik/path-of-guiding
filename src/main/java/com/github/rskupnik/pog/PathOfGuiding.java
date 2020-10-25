package com.github.rskupnik.pog;

public class PathOfGuiding {

    private static final String HARDCODED_POE_LOCATION = "C:/app/poe-test";

    private void start() {
        Parser.getInstance().startScanning(HARDCODED_POE_LOCATION);
        //UIBoot.boot();
        while (true) {

        }
    }

    public static void main(String[] args) {
        new PathOfGuiding().start();
    }
}