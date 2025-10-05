package me.choicore.samples.complex.domain.model;

import jakarta.annotation.Nonnull;
import lombok.Getter;

@Getter
public class Complex {
    private Long id;
    private String code;
    private String name;
    private boolean active;

    public static Complex create(
            @Nonnull String code,
            @Nonnull String name
    ) {
        Complex complex = new Complex();
        complex.code = code;
        complex.name = name;
        complex.active = true;
        return complex;
    }

    public static Complex of(
            @Nonnull Long id,
            @Nonnull String code,
            @Nonnull String name,
            boolean active
    ) {
        Complex complex = new Complex();
        complex.id = id;
        complex.code = code;
        complex.name = name;
        complex.active = active;
        return complex;
    }
}
