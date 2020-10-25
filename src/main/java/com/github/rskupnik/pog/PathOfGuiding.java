package com.github.rskupnik.pog;

public class PathOfGuiding {

    private static final String HARDCODED_POE_LOCATION = "C:/app/poe-test";

    private void start() throws Exception {
        Parser.getInstance().startScanning(HARDCODED_POE_LOCATION);
        //UIBoot.boot();
        while (true) {
            while (!Parser.getInstance().getTriggersQueue().isEmpty()) {
                System.out.println(Parser.getInstance().getTriggersQueue().take().getFullLine());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new PathOfGuiding().start();
    }
}