package uz.pdp.werehouse.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import uz.pdp.werehouse.model.base.BaseEntity;
import uz.pdp.werehouse.model.role.Role;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuthUser extends BaseEntity {

    private String fullName;
    private String username;
    private String password;
    private boolean active;

    @ManyToOne
    private Role role;

}