package me.choicore.samples.complex.domain.event;

import jakarta.annotation.Nonnull;
import me.choicore.samples.complex.domain.model.Building;
import me.choicore.samples.context.AbstractApplicationEvent;

public final class BuildingRegisteredEvent extends AbstractApplicationEvent<Building> {
    public BuildingRegisteredEvent(@Nonnull Building source) {
        super(source);
    }

    public static BuildingRegisteredEvent of(@Nonnull Building source) {
        return new BuildingRegisteredEvent(source);
    }
}
