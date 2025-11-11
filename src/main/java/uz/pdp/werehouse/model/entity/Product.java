package uz.pdp.werehouse.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uz.pdp.werehouse.model.base.BaseEntity;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product extends BaseEntity {

    @NotBlank(message = "Product name cannot be blank")
    private String name;

    @NotBlank(message = "Product code cannot be blank")
    @Size(min = 10, max = 10, message = "Product code must be 10 characters")
    private String code; // unique product code

    private boolean active =true;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "Category can't be null")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "measurement_id")
    @NotBlank(message = "Measurement can't be null")
    private Measurement measurement;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    @NotBlank(message = "Currency can't be null")
    private Currency currency;
}