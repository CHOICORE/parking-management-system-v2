package me.choicore.samples.complex.domain;

import me.choicore.samples.complex.domain.model.Unit;

import java.util.Optional;

public interface UnitRepository {
    Unit save(Unit building);

    Optional<Unit> findByNameAndBuildingId(String name, Long buildingId);
}
