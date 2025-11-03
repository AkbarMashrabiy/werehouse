package uz.pdp.werehouse.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinTable;
import uz.pdp.werehouse.model.base.BaseEntity;
import lombok.*;
import uz.pdp.werehouse.model.enums.MeasurementType;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Measurement extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @JoinTable(name = "measurement_type")
    @NotBlank(message = "Measurement name cannot be blank")
    private MeasurementType name; // e.g. kg, litr, dona
    private boolean active = true;
}