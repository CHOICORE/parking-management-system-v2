package me.choicore.samples.complex.infrastructure.persistence.jpa.repository;

import me.choicore.samples.complex.infrastructure.persistence.jpa.entity.ComplexEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplexEntityRepository extends JpaRepository<ComplexEntity, Long> {
}
