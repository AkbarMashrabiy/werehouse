package uz.pdp.werehouse.model.entity;

import jakarta.persistence.Entity;
import uz.pdp.werehouse.model.base.BaseEntity;
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
public class Supplier extends BaseEntity {

    @NotBlank(message = "Supplier name cannot be blank")
    private String name;

    @NotBlank(message = "Supplier phone number cannot be blank")
    @Size (min = 12, max = 12, message = "Supplier phone number must be 12 digits")
    private String phoneNumber;

    private boolean active = true;
}