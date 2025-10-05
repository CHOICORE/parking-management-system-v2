package me.choicore.samples.complex.infrastructure.persistence.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.samples.complex.domain.model.Building;
import me.choicore.samples.complex.domain.BuildingRepository;
import me.choicore.samples.complex.infrastructure.persistence.jpa.entity.BuildingEntity;
import me.choicore.samples.complex.infrastructure.persistence.jpa.repository.BuildingEntityRepository;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class BuildingJpaRepository implements BuildingRepository {
    private final BuildingEntityRepository buildingEntityRepository;

    @Override
    public Building save(Building building) {
        return buildingEntityRepository.save(BuildingEntity.from(building)).to();
    }
}
