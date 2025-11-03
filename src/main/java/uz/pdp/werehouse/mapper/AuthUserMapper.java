package uz.pdp.werehouse.mapper;

import org.springframework.stereotype.Component;
import uz.pdp.werehouse.model.dto.AuthUserDTO;
import uz.pdp.werehouse.model.entity.AuthUser;
import uz.pdp.werehouse.model.role.Role;

@Component
public class AuthUserMapper {

    public static AuthUser toAuthUser(AuthUserDTO userDTO){

        Role role = new Role();
        role.setName(userDTO.getRoleName());

        AuthUser authUser = new AuthUser();
        authUser.setId(userDTO.getId());
        authUser.setUsername(userDTO.getUsername());
        authUser.setFullName(userDTO.getFullName());
        authUser.setActive(userDTO.getActive());
        authUser.setRole(role);
        return authUser;
    }

    public static AuthUserDTO toAuthUserDTO(AuthUser user){
        return AuthUserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .fullName(user.getFullName())
                .roleName(user.getRole().getName())
                .active(user.isActive())
                .build();
    }

}
