package me.choicore.samples.complex.domain.model;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.util.Objects;

public record UnitReference(
        @Nullable Long id,
        @Nullable String name
) {
    public static UnitReference idOnly(@Nonnull Long id) {
        Objects.requireNonNull(id, "id must not be null");
        return new UnitReference(id, null);
    }

    public static UnitReference nameOnly(@Nonnull String name) {
        Objects.requireNonNull(name, "name must not be null");
        return new UnitReference(null, name);
    }

    public static UnitReference of(@Nonnull Unit unit) {
        return new UnitReference(unit.getId(), unit.getName());
    }
}
