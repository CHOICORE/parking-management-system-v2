package me.choicore.samples.complex.domain;

import me.choicore.samples.complex.domain.model.Building;
import me.choicore.samples.complex.domain.model.BuildingReference;
import me.choicore.samples.complex.domain.event.BuildingRegisteredEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RecordApplicationEvents
@Transactional
class BuildingRegistrarTests {
    @Autowired
    private BuildingRegistrar buildingRegistrar;

    @Autowired
    private ApplicationEvents applicationEvents;

    @Test
    void t1() {
        Long complexId = 1L;
        String name = "101동";

        BuildingReference result = buildingRegistrar.register(Building.create(complexId, name));

        assertThat(result.id()).isNotNull();
        assertThat(result.name()).isEqualTo(name);

        Optional<BuildingRegisteredEvent> event = applicationEvents.stream(BuildingRegisteredEvent.class).findFirst();
        assertThat(event).as("BuildingRegisteredEvent must be published").isPresent();

        Building source = event.get().source();
        assertThat(source.getId()).isEqualTo(result.id());
        assertThat(source.getName()).isEqualTo(result.name());
        assertThat(source.isActive()).isTrue();
    }
}