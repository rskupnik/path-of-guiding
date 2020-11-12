package com.github.rskupnik.pog.core;


import com.github.rskupnik.pog.core.domain.BuildDefinition;
import com.github.rskupnik.pog.core.domain.LevelTrigger;
import com.github.rskupnik.pog.core.domain.Trigger;
import com.github.rskupnik.pog.core.ports.BuildLoader;
import com.github.rskupnik.pog.core.ports.LogScanner;
import com.github.rskupnik.pog.core.ports.UI;

import javax.inject.Inject;

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

    private static final String HARDCODED_POE_LOCATION = "C:/app/steam/steamapps/common/Path of Exile";

    private final LogScanner logScanner;
    private final BuildLoader buildLoader;
    private final UI ui;

    @Inject
    public PathOfGuiding(LogScanner logScanner, BuildLoader buildLoader, UI ui) {
        this.logScanner = logScanner;
        this.buildLoader = buildLoader;
        this.ui = ui;
    }

    public void start() throws Exception {
        BuildDefinition build = buildLoader.load(SAMPLE_JSON).getOrElseThrow(t -> t);
        System.out.println(build);

        logScanner.startScan(HARDCODED_POE_LOCATION);

        try {
            while (!logScanner.getQueue().isEmpty()) {
                Trigger trigger = logScanner.getQueue().take();
                System.out.println(trigger.getMessage());
                if (trigger instanceof LevelTrigger) {
                    System.out.println(((LevelTrigger) trigger).getLevel());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
//        BuildDef build = BuildLoader.getInstance().load(SAMPLE_JSON).getOrElseThrow(t -> t);
//        System.out.println(build);
//
//        Parser.getInstance().startScanning(HARDCODED_POE_LOCATION);
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
    }
}