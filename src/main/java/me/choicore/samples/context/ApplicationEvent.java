package me.choicore.samples.context;

import java.time.Instant;

public interface ApplicationEvent<T> {
    T source();

    Instant timestamp();
}
