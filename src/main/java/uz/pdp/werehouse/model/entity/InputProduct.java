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
@Builder
@Entity
public class InputProduct extends BaseEntity {

    @ManyToOne
    private Product product;

    @ManyToOne
    private Input input;

    private Double amount;
    private Double price;
    private LocalDateTime expireDate;
}
