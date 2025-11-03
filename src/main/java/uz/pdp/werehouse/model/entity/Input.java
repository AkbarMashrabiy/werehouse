package uz.pdp.werehouse.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uz.pdp.werehouse.model.base.BaseEntity;
import java.time.LocalDateTime;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Input extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    @NotBlank(message = "warehouse can't be null")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    @NotBlank(message = "supplier can't be null")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    @NotBlank(message = "currency can't be null")
    private Currency currency;

    @NotBlank(message = "factureNumber can't be null")
    @Size(min = 12, max = 12, message = "factureNumber must be 12 characters")
    private String factureNumber;

    @NotBlank(message = "date can't be null")
    private LocalDateTime date;
}