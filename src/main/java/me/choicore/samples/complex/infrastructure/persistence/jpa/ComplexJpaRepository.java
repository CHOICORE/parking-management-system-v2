package me.choicore.samples.complex.infrastructure.persistence.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.samples.complex.domain.model.Complex;
import me.choicore.samples.complex.infrastructure.persistence.jpa.repository.ComplexEntityRepository;
import me.choicore.samples.complex.domain.ComplexRepository;
import me.choicore.samples.complex.infrastructure.persistence.jpa.entity.ComplexEntity;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class ComplexJpaRepository implements ComplexRepository {
    private final ComplexEntityRepository complexEntityRepository;

    @Override
    public Complex save(final Complex complex) {
        return complexEntityRepository.save(ComplexEntity.from(complex)).to();
    }
}
