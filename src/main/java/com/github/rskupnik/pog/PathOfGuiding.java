package com.github.rskupnik.pog;

import com.github.rskupnik.pog.build.BuildLoader;
import com.github.rskupnik.pog.build.model.Build;
import com.github.rskupnik.pog.commons.triggers.AreaTrigger;
import com.github.rskupnik.pog.commons.triggers.LevelTrigger;
import com.github.rskupnik.pog.commons.triggers.Trigger;

import java.util.Optional;

public class PathOfGuiding {

    private static final String SAMPLE_JSON = """
            {
                "name": "test",
                "triggers": [
                    {
                        "type": "level",
                        "message": "Hello World",
                        "level": 5
                    }
                ]
            }
    """;

    private static final String HARDCODED_POE_LOCATION = "C:/app/poe-test";

    private void start() throws Exception {
        //Parser.getInstance().startScanning(HARDCODED_POE_LOCATION);
        //UIBoot.boot();
//        while (true) {
//            while (!Parser.getInstance().getTriggersQueue().isEmpty()) {
//                Trigger trigger = Parser.getInstance().getTriggersQueue().take();
//                if (trigger instanceof LevelTrigger) {
//                    LevelTrigger levelTrigger = (LevelTrigger) trigger;
//                    System.out.println(levelTrigger.getLevel());
//                } else if (trigger instanceof AreaTrigger) {
//                    AreaTrigger areaTrigger = (AreaTrigger) trigger;
//                    System.out.println(areaTrigger.getArea());
//                }
//                System.out.println(trigger.getFullLine());
//            }
//        }
        Optional<Build> build = BuildLoader.getInstance().load(SAMPLE_JSON);
        System.out.println(build.get());
    }

    public static void main(String[] args) throws Exception {
        new PathOfGuiding().start();
    }
}