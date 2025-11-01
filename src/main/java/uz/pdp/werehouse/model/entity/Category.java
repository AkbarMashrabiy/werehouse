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
@Builder
@Entity
public class Category extends BaseEntity {

    private String name;

    @ManyToOne
    private Category parentCategory; // for nested categories
}