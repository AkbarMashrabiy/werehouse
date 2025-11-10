package uz.pdp.werehouse.mapper;

import org.springframework.stereotype.Component;
import uz.pdp.werehouse.model.dto.AuthUserDTO;
import uz.pdp.werehouse.model.entity.AuthUser;

import java.util.List;
import java.util.Optional;


@Component
public class AuthUserMapper {

    public static AuthUser toAuthUser(AuthUserDTO userDTO){

        AuthUser authUser = new AuthUser();
        authUser.setId(userDTO.getId());
        authUser.setUsername(userDTO.getUsername());
        authUser.setFullName(userDTO.getFullName());
        authUser.setActive(userDTO.isActive());
        authUser.setRoles(userDTO.getRoles());
        return authUser;
    }

    public static AuthUserDTO toAuthUserDTO(AuthUser user){
        return AuthUserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .fullName(user.getFullName())
                .roles(user.getRoles())
                .active(user.isActive())
                .build();
    }

    public Optional<List<AuthUserDTO>> toDto(List<AuthUser> all) {
        return  Optional.of(all.stream().map(AuthUserMapper::toAuthUserDTO).toList());
    }
}
