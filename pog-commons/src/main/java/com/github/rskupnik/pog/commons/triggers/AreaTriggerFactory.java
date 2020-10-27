package com.github.rskupnik.pog.commons.triggers;

import java.util.Optional;
import java.util.regex.Pattern;

public class AreaTriggerFactory extends TriggerFactory<AreaTrigger> {

    private static final Pattern PATTERN = Pattern.compile(".*\\s:.* You have entered (?<area>.*).");

    @Override
    public Optional<AreaTrigger> match(String line) {
        var matcher = PATTERN.matcher(line);
        return matcher.matches() ? Optional.of(new AreaTrigger(line, matcher.group("area"))) : Optional.empty();
    }
}
