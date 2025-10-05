package me.choicore.samples.complex.infrastructure.persistence.jpa.entity;

import jakarta.persistence.*;
import me.choicore.samples.complex.domain.model.Unit;

@Entity
@Table(name = "units")
public class UnitEntity {
    @Id
    @Column(name = "unit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long buildingId;
    private String name;
    private boolean deleted;

    public static UnitEntity from(final Unit unit) {
        UnitEntity entity = new UnitEntity();
        entity.id = unit.getId();
        entity.buildingId = unit.getBuildingId();
        entity.name = unit.getName();
        entity.deleted = !unit.isActive();
        return entity;
    }

    public Unit to() {
        return Unit.of(
                this.id,
                this.buildingId,
                this.name,
                !this.deleted
        );
    }
}
