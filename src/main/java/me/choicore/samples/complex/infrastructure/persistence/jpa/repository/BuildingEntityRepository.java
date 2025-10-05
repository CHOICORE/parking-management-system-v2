package me.choicore.samples.complex.infrastructure.persistence.jpa.repository;

import me.choicore.samples.complex.infrastructure.persistence.jpa.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingEntityRepository extends JpaRepository<BuildingEntity, Long> {
}
