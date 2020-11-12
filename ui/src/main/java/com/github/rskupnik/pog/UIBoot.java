package com.github.rskupnik.pog;

import com.github.rskupnik.pog.core.ports.UI;
import com.github.rskupnik.pog.ui.PogApplication;

public class UIBoot implements UI {

    public void start() {
        PogApplication.launchUI();
    }
}
