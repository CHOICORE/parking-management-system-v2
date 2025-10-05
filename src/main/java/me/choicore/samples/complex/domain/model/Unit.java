package me.choicore.samples.complex.domain.model;

import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class Unit {
    private Long id;
    private Long buildingId;
    private String name;
    private boolean active;

    public static Unit create(
           @Nonnull Long buildingId,
           @Nonnull String name
    ) {
        Unit unit = new Unit();
        unit.buildingId = buildingId;
        unit.name = name;
        unit.active = true;
        return unit;
    }

    public static Unit of(
           @Nonnull Long id,
           @Nonnull Long buildingId,
           @Nonnull String name,
            final boolean active
    ) {
        Unit unit = new Unit();
        unit.id = id;
        unit.buildingId = buildingId;
        unit.name = name;
        unit.active = active;
        return unit;
    }
}
