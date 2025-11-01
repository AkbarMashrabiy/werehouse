package uz.pdp.werehouse.model.entity;

import jakarta.persistence.Entity;
import uz.pdp.werehouse.model.base.BaseEntity;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Measurement extends BaseEntity {
    private String name; // e.g. kg, litr, dona
    private boolean active;
}