package me.choicore.samples.complex.infrastructure.persistence.jpa.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import me.choicore.samples.complex.domain.model.Complex;

@Getter
@Entity
@Table(name = "complexes")
public class ComplexEntity {
    @Id
    @Column(name = "complex_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private boolean deleted;

    public static ComplexEntity from(
           @Nonnull Complex complex
    ) {
        ComplexEntity complexEntity = new ComplexEntity();
        complexEntity.code = complex.getCode();
        complexEntity.name = complex.getName();
        complexEntity.deleted = !complex.isActive();
        return complexEntity;
    }

    public Complex to() {
        return Complex.of(id, code, name, !deleted);
    }
}
