package me.choicore.samples.complex.domain.event;

import jakarta.annotation.Nonnull;
import me.choicore.samples.complex.domain.model.Complex;
import me.choicore.samples.context.AbstractApplicationEvent;

public final class ComplexRegisteredEvent extends AbstractApplicationEvent<Complex> {
    public ComplexRegisteredEvent(@Nonnull Complex source) {
        super(source);
    }

    public static ComplexRegisteredEvent of(@Nonnull Complex source) {
        return new ComplexRegisteredEvent(source);
    }
}
