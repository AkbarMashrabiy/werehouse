package uz.pdp.werehouse.model.dto;

import lombok.*;
import uz.pdp.werehouse.model.entity.Address;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseDto {
    @NotBlank(message = "Warehouse id cannot be blank")
    private String id;
    @NotBlank(message = "Warehouse name cannot be blank")
    private String name;
    @NotBlank(message = "Warehouse phone number cannot be blank")
    private String phoneNumber;
    @NotBlank(message = "Warehouse email cannot be blank")
    private AddressDto address;
    @NotBlank(message = "Warehouse active cannot be blank")
    private boolean active;
}
