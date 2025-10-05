package me.choicore.samples.complex.infrastructure.persistence.jpa.repository;

import me.choicore.samples.complex.infrastructure.persistence.jpa.entity.ComplexEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComplexEntityRepository extends JpaRepository<ComplexEntity, Long> {
    Optional<ComplexEntity> findByCode(String code);
}
