package me.choicore.samples.complex.domain;

import me.choicore.samples.complex.domain.model.Complex;

import java.util.Optional;

public interface ComplexRepository {
    Complex save(Complex complex);

    Optional<Complex> findById(Long id);

    Optional<Complex> findByCode(String code);
}
