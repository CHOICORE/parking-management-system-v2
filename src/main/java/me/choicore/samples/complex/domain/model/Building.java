package me.choicore.samples.complex.domain.model;

import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class Building {
    private Long id;
    private Long complexId;
    private String name;
    private boolean active;

    public static Building create(
            @Nonnull Long complexId,
            @Nonnull String name
    ) {
        Building building = new Building();
        building.complexId = complexId;
        building.name = name;
        building.active = true;
        return building;
    }

    public static Building of(
            @Nonnull Long id,
            @Nonnull Long complexId,
            @Nonnull String name,
            boolean active
    ) {
        Building building = new Building();
        building.id = id;
        building.complexId = complexId;
        building.name = name;
        building.active = active;
        return building;
    }
}
