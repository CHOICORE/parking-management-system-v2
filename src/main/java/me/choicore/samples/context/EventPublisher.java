package me.choicore.samples.context;

public interface EventPublisher {
    void publish(ApplicationEvent<?> event);
}
