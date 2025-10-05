package me.choicore.samples.complex.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.samples.complex.domain.model.Complex;
import me.choicore.samples.complex.domain.model.ComplexReference;
import me.choicore.samples.complex.domain.event.ComplexRegisteredEvent;
import me.choicore.samples.context.EventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ComplexRegistrar {
    private final ComplexRepository complexRepository;
    private final EventPublisher eventPublisher;

    @Transactional
    public ComplexReference register(Complex complex) {
        Complex saved = complexRepository.save(complex);

        eventPublisher.publish(ComplexRegisteredEvent.of(saved));

        ComplexReference complexReference = ComplexReference.of(saved);

        log.info("Complex registered: id={}, code={}, name={}", complexReference.id(), complexReference.code(), complexReference.name());

        return complexReference;
    }
}
