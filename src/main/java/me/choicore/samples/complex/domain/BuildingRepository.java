package me.choicore.samples.complex.domain;

import me.choicore.samples.complex.domain.model.Building;

import java.util.Optional;

public interface BuildingRepository {
    Building save(Building building);

    Optional<Building> findByNameAndComplexId(String name, Long complexId);
}
