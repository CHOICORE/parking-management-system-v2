package me.choicore.samples.context;

import java.time.Instant;

public abstract class AbstractApplicationEvent<T> implements ApplicationEvent<T> {
    protected final T source;
    protected final Instant timestamp;

    public AbstractApplicationEvent(final T source, final Instant timestamp) {
        this.source = source;
        this.timestamp = timestamp;
    }

    public AbstractApplicationEvent(final T source) {
        this(source, Instant.now());
    }

    @Override
    public T source() {
        return source;
    }

    @Override
    public Instant timestamp() {
        return timestamp;
    }
}
