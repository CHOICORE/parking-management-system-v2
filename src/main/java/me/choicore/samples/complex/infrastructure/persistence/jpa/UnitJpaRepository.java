package me.choicore.samples.complex.infrastructure.persistence.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.choicore.samples.complex.domain.UnitRepository;
import me.choicore.samples.complex.domain.model.Unit;
import me.choicore.samples.complex.infrastructure.persistence.jpa.entity.UnitEntity;
import me.choicore.samples.complex.infrastructure.persistence.jpa.repository.UnitEntityRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Repository
public class UnitJpaRepository implements UnitRepository {
    private final UnitEntityRepository unitJpaRepository;

    @Override
    public Unit save(final Unit unit) {
        return unitJpaRepository.save(UnitEntity.from(unit)).to();
    }

    @Override
    public Optional<Unit> findByNameAndBuildingId(final String name, final Long buildingId) {
        return unitJpaRepository.findByNameAndBuildingId(name, buildingId).map(UnitEntity::to);
    }
}
