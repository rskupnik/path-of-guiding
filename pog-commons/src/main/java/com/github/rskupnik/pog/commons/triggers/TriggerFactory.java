package com.github.rskupnik.pog.commons.triggers;

import java.util.Optional;

public abstract class TriggerFactory<T extends Trigger> {

    public abstract Optional<T> match(String line);
}
