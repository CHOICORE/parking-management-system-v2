package me.choicore.samples.complex.domain.event;

import jakarta.annotation.Nonnull;
import me.choicore.samples.complex.domain.model.Unit;
import me.choicore.samples.context.AbstractApplicationEvent;

public final class UnitRegisteredEvent extends AbstractApplicationEvent<Unit> {
    public UnitRegisteredEvent(@Nonnull Unit source) {
        super(source);
    }

    public static UnitRegisteredEvent of(@Nonnull Unit source) {
        return new UnitRegisteredEvent(source);
    }
}
