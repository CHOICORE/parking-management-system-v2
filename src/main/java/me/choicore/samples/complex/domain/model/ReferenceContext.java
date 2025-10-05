package me.choicore.samples.complex.domain.model;

import jakarta.annotation.Nonnull;

public record ReferenceContext(
        @Nonnull ComplexReference complexReference,
        @Nonnull BuildingReference buildingReference,
        @Nonnull UnitReference unitReference
) {
}
