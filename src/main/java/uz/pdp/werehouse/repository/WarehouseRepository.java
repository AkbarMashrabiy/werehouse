package uz.pdp.werehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.werehouse.model.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, String> {
    boolean existsByName(String name);
}
