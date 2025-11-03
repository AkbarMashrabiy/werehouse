package uz.pdp.werehouse.model.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.werehouse.model.base.BaseEntity;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Address extends BaseEntity{
    @NotBlank(message = "Country shouldn't be null")
    private String country;

    @NotBlank(message = "City shouldn't be null")
    private String city;

    @NotBlank(message = "Street shouldn't be null")
    private String street;

    @NotBlank(message = "Home shouldn't be null")
    private String home;

    @NotBlank(message = "Apartment shouldn't be null")
    private String apartment;

    @NotBlank(message = "Zip code shouldn't be null")
    private String zipCode;
}
