package uz.pdp.werehouse.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uz.pdp.werehouse.model.base.BaseEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class OutputProduct extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotBlank(message = "Product cannot be blank")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "output_id")
    @NotBlank(message = "Output cannot be blank")
    private Output output;

    @NotBlank(message = "Amount cannot be blank")
    private Double amount;

    @NotBlank(message = "Price cannot be blank")
    private Double price;
}
