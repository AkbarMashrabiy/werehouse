package uz.pdp.werehouse.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import uz.pdp.werehouse.model.base.BaseEntity;
import java.time.LocalDateTime;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Input extends BaseEntity {

    @ManyToOne
    private Werehouse warehouse;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Currency currency;

    private String factureNumber;
    private LocalDateTime date;
}