package me.choicore.samples.context;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SpringEventPublisher implements EventPublisher {
    private final ApplicationEventPublisher delegate;

    @Override
    public void publish(final ApplicationEvent<?> event) {
        delegate.publishEvent(event);
    }
}
