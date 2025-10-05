package me.choicore.samples.complex.domain;

import me.choicore.samples.complex.domain.model.Unit;
import me.choicore.samples.complex.domain.model.UnitReference;
import me.choicore.samples.complex.domain.event.UnitRegisteredEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RecordApplicationEvents
class UnitRegistrarTests {
    @Autowired
    private UnitRegistrar unitRegistrar;

    @Autowired
    private ApplicationEvents applicationEvents;

    @Test
    void t1() {
        Long buildingId = 1L;
        String name = "101호";

        UnitReference result = unitRegistrar.register(Unit.create(buildingId, name));

        assertThat(result.id()).isNotNull();
        assertThat(result.name()).isEqualTo(name);

        Optional<UnitRegisteredEvent> event = applicationEvents.stream(UnitRegisteredEvent.class).findFirst();
        assertThat(event).as("UnitRegisteredEvent must be published").isPresent();

        Unit source = event.get().source();
        assertThat(source.getId()).isEqualTo(result.id());
        assertThat(source.getName()).isEqualTo(result.name());
        assertThat(source.isActive()).isTrue();
    }
}