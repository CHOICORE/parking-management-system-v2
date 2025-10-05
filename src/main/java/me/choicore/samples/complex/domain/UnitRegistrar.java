package me.choicore.samples.complex.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.samples.complex.domain.model.Unit;
import me.choicore.samples.complex.domain.model.UnitReference;
import me.choicore.samples.complex.domain.event.UnitRegisteredEvent;
import me.choicore.samples.context.EventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class UnitRegistrar {
    private final UnitRepository unitRepository;
    private final EventPublisher eventPublisher;

    @Transactional
    public UnitReference register(Unit building) {
        Unit saved = unitRepository.save(building);

        eventPublisher.publish(UnitRegisteredEvent.of(saved));

        UnitReference buildingReference = UnitReference.of(saved);

        log.info("Unit registered: id={}, name={}", buildingReference.id(), buildingReference.name());

        return buildingReference;
    }
}
