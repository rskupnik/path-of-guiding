package com.github.rskupnik.pog.commons.triggers;

public class AreaTrigger extends Trigger {

    private final String area;

    public AreaTrigger(String fullLine, String area) {
        super(fullLine);
        this.area = area;
    }

    public String getArea() {
        return area;
    }
}
