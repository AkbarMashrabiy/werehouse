package uz.pdp.werehouse.mapper;

import org.springframework.stereotype.Component;
import uz.pdp.werehouse.model.dto.AddressDto;
import uz.pdp.werehouse.model.entity.Address;

@Component
public class AddressMapper {

    public AddressDto toDTO(Address address) {

        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setCountry(address.getCountry());
        dto.setCity(address.getCity());
        dto.setStreet(address.getStreet());
        dto.setHome(address.getHome());
        dto.setApartment(address.getApartment());
        dto.setZipCode(address.getZipCode());
        return dto;
    }

    public  Address toEntity(AddressDto dto) {
        Address address = new Address();
        address.setCountry(dto.getCountry());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setHome(dto.getHome());
        address.setApartment(dto.getApartment());
        address.setZipCode(dto.getZipCode());
        return address;
    }

}
