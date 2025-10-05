package me.choicore.samples.complex.infrastructure.persistence.jpa.repository;

import me.choicore.samples.complex.infrastructure.persistence.jpa.entity.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitEntityRepository extends JpaRepository<UnitEntity, Long> {
    Optional<UnitEntity> findByNameAndBuildingId(String name, Long buildingId);
}
