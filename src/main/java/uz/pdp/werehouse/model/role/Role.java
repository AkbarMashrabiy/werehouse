package uz.pdp.werehouse.model.role;

import jakarta.persistence.Entity;
import uz.pdp.werehouse.model.base.BaseEntity;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role extends BaseEntity {
    private String name; // e.g. ADMIN, WAREHOUSE_MANAGER, SELLER

}