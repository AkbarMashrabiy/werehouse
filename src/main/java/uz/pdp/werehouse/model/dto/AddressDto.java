package uz.pdp.werehouse.model.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {
    @NotBlank(message = "Id shouldn't be null")
    private String  id;
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