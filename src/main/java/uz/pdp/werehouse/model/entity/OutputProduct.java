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
public class OutputProduct extends BaseEntity {

    @ManyToOne
    private Product product;

    @ManyToOne
    private Output output;

    private Double amount;
    private Double price;
}
