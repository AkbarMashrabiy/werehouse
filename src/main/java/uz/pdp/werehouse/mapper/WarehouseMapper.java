package uz.pdp.werehouse.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.pdp.werehouse.model.dto.AddressDto;
import uz.pdp.werehouse.model.dto.WarehouseDto;
import uz.pdp.werehouse.model.entity.Address;
import uz.pdp.werehouse.model.entity.Warehouse;

@Component
@RequiredArgsConstructor
public class WarehouseMapper {
    private final AddressMapper addressMapper;
    public WarehouseDto toDto(Warehouse warehouse) {
        WarehouseDto dto = new WarehouseDto();
        dto.setId(warehouse.getId());
        dto.setName(warehouse.getName());
        dto.setAddress(addressMapper.toDTO(warehouse.getAddress()));
        dto.setActive(warehouse.isActive());
        dto.setPhoneNumber(warehouse.getPhoneNumber());
        return dto;
    }

    public Warehouse toEntity(WarehouseDto dto) {
        Warehouse entity = new Warehouse();
        entity.setName(dto.getName());
        entity.setAddress(addressMapper.toEntity(dto.getAddress()));
        entity.setActive(dto.isActive());
        entity.setPhoneNumber(dto.getPhoneNumber());
        return entity;
    }

}



