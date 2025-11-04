package uz.pdp.werehouse.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import uz.pdp.werehouse.model.base.BaseEntity;
import lombok.*;
import uz.pdp.werehouse.model.enums.CurrencyName;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Currency extends BaseEntity {
    @NotBlank(message = "Currency name cannot be blank")
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "currency_name")
    private CurrencyName name; // e.g. USD, UZS, EUR
    private boolean active = true;


}