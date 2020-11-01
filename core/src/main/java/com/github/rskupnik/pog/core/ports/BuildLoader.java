package com.github.rskupnik.pog.core.ports;

import com.github.rskupnik.pog.core.domain.BuildDefinition;
import io.vavr.control.Either;

public interface BuildLoader {

    Either<Exception, BuildDefinition> load(String input);
}
