package com.github.rskupnik.pog.commons.triggers;

import java.util.Optional;
import java.util.regex.Pattern;

public class LevelTriggerFactory extends TriggerFactory<LevelTrigger> {

    private static final Pattern PATTERN = Pattern.compile(".*\\s:.* is now level (?<level>\\d*)");

    @Override
    public Optional<LevelTrigger> match(String line) {
        var matcher = PATTERN.matcher(line);
        return matcher.matches() ? Optional.of(new LevelTrigger(line, Integer.parseInt(matcher.group("level")))) : Optional.empty();
    }
}
