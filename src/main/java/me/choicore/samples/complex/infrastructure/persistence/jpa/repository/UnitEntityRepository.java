package me.choicore.samples.complex.infrastructure.persistence.jpa.repository;

import me.choicore.samples.complex.infrastructure.persistence.jpa.entity.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitEntityRepository extends JpaRepository<UnitEntity, Long> {
}
