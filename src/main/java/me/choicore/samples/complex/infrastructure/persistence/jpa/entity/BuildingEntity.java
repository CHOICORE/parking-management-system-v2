package me.choicore.samples.complex.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import me.choicore.samples.complex.domain.model.Building;

@Getter
@Entity
@Table(name = "buildings")
public class BuildingEntity {
    @Id
    @Column(name = "building_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long complexId;
    private String name;
    private boolean deleted;

    public static BuildingEntity from(final Building building) {
        BuildingEntity entity = new BuildingEntity();
        entity.id = building.getId();
        entity.complexId = building.getComplexId();
        entity.name = building.getName();
        entity.deleted = !building.isActive();
        return entity;
    }

    public Building to() {
        return Building.of(
                this.id,
                this.complexId,
                this.name,
                !this.deleted
        );
    }
}
