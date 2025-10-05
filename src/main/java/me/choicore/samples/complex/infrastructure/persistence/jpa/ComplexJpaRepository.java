package me.choicore.samples.complex.infrastructure.persistence.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.samples.complex.domain.ComplexRepository;
import me.choicore.samples.complex.domain.model.Complex;
import me.choicore.samples.complex.infrastructure.persistence.jpa.entity.ComplexEntity;
import me.choicore.samples.complex.infrastructure.persistence.jpa.repository.ComplexEntityRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Repository
@Transactional(readOnly = true)
public class ComplexJpaRepository implements ComplexRepository {
    private final ComplexEntityRepository complexEntityRepository;

    @Override
    @Transactional
    public Complex save(final Complex complex) {
        return complexEntityRepository.save(ComplexEntity.from(complex)).to();
    }

    @Override
    public Optional<Complex> findById(final Long id) {
        return complexEntityRepository.findById(id).map(ComplexEntity::to);
    }

    @Override
    public Optional<Complex> findByCode(final String code) {
        return complexEntityRepository.findByCode(code).map(ComplexEntity::to);
    }
}
