package uz.pdp.werehouse.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uz.pdp.werehouse.model.base.BaseEntity;
import java.time.LocalDateTime;
import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class InputProduct extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotBlank(message = "Product cannot be blank")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "input_id")
    @NotBlank(message = "Input cannot be blank")
    private Input input;

    @NotBlank(message = "Amount cannot be blank")
    private Double amount;

    @NotBlank(message = "Price cannot be blank")
    private Double price;

    @NotBlank(message = "Expire date cannot be blank")
    private LocalDateTime expireDate;
}
