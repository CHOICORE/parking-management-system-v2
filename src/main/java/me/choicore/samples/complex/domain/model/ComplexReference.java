package me.choicore.samples.complex.domain.model;

import jakarta.annotation.Nonnull;

import java.util.Objects;

public record ComplexReference(
        Long id,
        String code,
        String name
) {

    public static ComplexReference of(@Nonnull Complex complex) {
        return new ComplexReference(complex.getId(), complex.getCode(), complex.getName());
    }

    public static ComplexReference idOnly(@Nonnull Long id) {
        Objects.requireNonNull(id, "id must not be null");
        return new ComplexReference(id, null, null);
    }
}
