package me.choicore.samples.complex.infrastructure.persistence.jpa.repository;

import me.choicore.samples.complex.infrastructure.persistence.jpa.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuildingEntityRepository extends JpaRepository<BuildingEntity, Long> {
    Optional<BuildingEntity> findByNameAndComplexId(String name, Long complexId);
}
