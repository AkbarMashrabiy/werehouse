package uz.pdp.werehouse.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.werehouse.mapper.AddressMapper;
import uz.pdp.werehouse.mapper.WarehouseMapper;
import uz.pdp.werehouse.model.dto.MyResponse;
import uz.pdp.werehouse.model.dto.WarehouseDto;
import uz.pdp.werehouse.model.entity.Warehouse;
import uz.pdp.werehouse.repository.WarehouseRepository;
import uz.pdp.werehouse.service.WarehouseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository repository;
    private final WarehouseMapper mapper;
    private final AddressMapper addressMapper;


    @Override
    public MyResponse addWarehouse(WarehouseDto warehouse) {
        Warehouse entity = mapper.toEntity(warehouse);
        if (entity == null | repository.existsByName(warehouse.getName())){
            return MyResponse.FAILED_TO_CREATE;
        }

        repository.save(entity);

        return MyResponse.SUCCESSFULLY_CREATED;
    }

    @Override
    public WarehouseDto getWarehouseById(String id) {
        return repository.findById(id).map(mapper::toDto).orElse(null);
    }

    @Override
    public List<WarehouseDto> getAllWarehouses() {
        List<WarehouseDto> list = repository.findAll().stream().map(mapper::toDto).toList();
        if (list.isEmpty()){
            return null;
        }
        return list;
    }

    @Override
    public MyResponse deleteWarehouse(String id) {
        if (repository.existsById(id)){
            Warehouse warehouse = repository.findById(id).get();
            warehouse.setActive(false);
            repository.save(warehouse);
            return MyResponse.SUCCESSFULLY_DELETED;
        }
        return MyResponse.CANT_DELETE;
    }

    @Override
    public MyResponse updateWarehouse(String id, WarehouseDto warehouseDto) {
        if (repository.existsById(id)){
            Warehouse warehouse = repository.findById(id).get();
            warehouse.setName(warehouseDto.getName());
            warehouse.setAddress(addressMapper.toEntity(warehouseDto.getAddress()));
            warehouse.setActive(warehouseDto.isActive());
            warehouse.setPhoneNumber(warehouseDto.getPhoneNumber());
            repository.save(warehouse);
            return MyResponse.SUCCESSFULLY_UPDATED;
        }
    return MyResponse.WAREHOUSE_NOT_FOUND;
    }
}
