package me.choicore.samples.complex.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.samples.complex.domain.model.Building;
import me.choicore.samples.complex.domain.model.BuildingReference;
import me.choicore.samples.complex.domain.event.BuildingRegisteredEvent;
import me.choicore.samples.context.EventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class BuildingRegistrar {
    private final BuildingRepository buildingRepository;
    private final EventPublisher eventPublisher;

    @Transactional
    public BuildingReference register(Building building) {
        Building saved = buildingRepository.save(building);

        eventPublisher.publish(BuildingRegisteredEvent.of(saved));

        BuildingReference buildingReference = BuildingReference.of(saved);

        log.info("Building registered: id={}, name={}", buildingReference.id(), buildingReference.name());

        return buildingReference;
    }
}
