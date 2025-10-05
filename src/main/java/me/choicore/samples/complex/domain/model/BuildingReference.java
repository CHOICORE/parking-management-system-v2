package me.choicore.samples.complex.domain.model;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.util.Objects;

public record BuildingReference(
        @Nullable Long id,
        @Nullable String name
) {
    public static BuildingReference nameOnly(@Nonnull String name) {
        Objects.requireNonNull(name, "name must not be null");
        return new BuildingReference(null, name);
    }

    public static BuildingReference idOnly(@Nonnull Long id) {
        Objects.requireNonNull(id, "id must not be null");
        return new BuildingReference(id, null);
    }

    public static BuildingReference of(@Nonnull Building building) {
        return new BuildingReference(building.getId(), building.getName());
    }
}