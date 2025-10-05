package me.choicore.samples.complex.domain;

import me.choicore.samples.complex.domain.model.Complex;
import me.choicore.samples.complex.domain.model.ComplexReference;
import me.choicore.samples.complex.domain.event.ComplexRegisteredEvent;
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
class ComplexRegistrarTests {
    @Autowired
    private ComplexRegistrar complexRegistrar;

    @Autowired
    private ApplicationEvents applicationEvents;

    @Test
    void t1() {
        String code = "CPX0001";
        String name = "개발 아파트";

        ComplexReference result = complexRegistrar.register(Complex.create(code, name));

        assertThat(result.id()).isNotNull();
        assertThat(result.code()).isEqualTo(code);
        assertThat(result.name()).isEqualTo(name);

        Optional<ComplexRegisteredEvent> event = applicationEvents.stream(ComplexRegisteredEvent.class).findFirst();
        assertThat(event).as("ComplexRegisteredEvent must be published").isPresent();

        Complex source = event.get().source();
        assertThat(source.getId()).isEqualTo(result.id());
        assertThat(source.getCode()).isEqualTo(result.code());
        assertThat(source.getName()).isEqualTo(result.name());
        assertThat(source.isActive()).isTrue();
    }
}