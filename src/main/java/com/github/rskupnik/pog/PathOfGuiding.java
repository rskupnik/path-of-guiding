package com.github.rskupnik.pog;

import com.github.rskupnik.pog.build.BuildLoader;
import com.github.rskupnik.pog.build.model.BuildDef;
import io.vavr.control.Either;

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
        BuildDef build = BuildLoader.getInstance().load(SAMPLE_JSON).getOrElseThrow(t -> t);
        System.out.println(build);
    }

    public static void main(String[] args) throws Exception {
        new PathOfGuiding().start();
    }
}