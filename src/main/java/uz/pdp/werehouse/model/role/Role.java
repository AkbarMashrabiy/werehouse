package uz.pdp.werehouse.model.role;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinTable;
import org.springframework.security.core.GrantedAuthority;
import uz.pdp.werehouse.model.base.BaseEntity;
import lombok.*;
import uz.pdp.werehouse.model.enums.RoleName;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity  implements GrantedAuthority {
    @Enumerated(EnumType.STRING)
    @JoinTable(name = "role_name")
    private RoleName roleName; // e.g. ADMIN, WAREHOUSE_MANAGER, SELLER

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }


    public Role() {
      super();
    }

    @Override
    public String getAuthority() {
        return this.roleName.name();
    }


    @JsonValue
    public Map<String, Object> toJson() {
        Map<String, Object> response = new HashMap<>();
        response.put("id", this.getId());
        response.put("name", this.getRoleName());
        return response;
    }



}