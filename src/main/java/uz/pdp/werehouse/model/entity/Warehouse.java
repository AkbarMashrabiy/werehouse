package uz.pdp.werehouse.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
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
public class Warehouse extends BaseEntity {

    @NotBlank(message = "Warehouse name cannot be blank")
    @Size (min = 3, max = 255, message = "Warehouse name must be between 3 and 255 characters")
    private String name;

    @NotBlank(message = "Warehouse phone number cannot be blank")
    @Size (min = 12, max = 12, message = "Warehouse phone number must be 12 digits")
    private String phoneNumber;

    @NotBlank(message = "Warehouse email cannot be blank")
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private boolean active = true;
}

