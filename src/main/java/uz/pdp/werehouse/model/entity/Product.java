package uz.pdp.werehouse.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import uz.pdp.werehouse.model.base.BaseEntity;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseEntity {

    private String name;
    private String code; // unique product code
    private boolean active;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Measurement measurement;

    @ManyToOne
    private Currency currency;
}