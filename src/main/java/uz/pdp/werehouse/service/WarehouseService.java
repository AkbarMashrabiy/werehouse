package uz.pdp.werehouse.service;

import uz.pdp.werehouse.model.dto.WarehouseDto;
import uz.pdp.werehouse.model.dto.MyResponse;

import java.util.List;

public interface WarehouseService {

    MyResponse addWarehouse(WarehouseDto warehouse);
    WarehouseDto getWarehouseById(String id);
    List<WarehouseDto> getAllWarehouses();
    MyResponse deleteWarehouse(String id);
    MyResponse updateWarehouse(String id, WarehouseDto warehouseDto);
}
