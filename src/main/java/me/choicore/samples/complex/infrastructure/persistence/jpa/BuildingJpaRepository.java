package me.choicore.samples.complex.infrastructure.persistence.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.samples.complex.domain.BuildingRepository;
import me.choicore.samples.complex.domain.model.Building;
import me.choicore.samples.complex.infrastructure.persistence.jpa.entity.BuildingEntity;
import me.choicore.samples.complex.infrastructure.persistence.jpa.repository.BuildingEntityRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Repository
@Transactional(readOnly = true)
public class BuildingJpaRepository implements BuildingRepository {
    private final BuildingEntityRepository buildingEntityRepository;

    @Override
    @Transactional
    public Building save(Building building) {
        return buildingEntityRepository.save(BuildingEntity.from(building)).to();
    }

    @Override
    public Optional<Building> findByNameAndComplexId(final String name, final Long complexId) {
        return buildingEntityRepository.findByNameAndComplexId(name, complexId).map(BuildingEntity::to);
    }
}
