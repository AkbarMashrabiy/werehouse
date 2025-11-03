package uz.pdp.werehouse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.werehouse.model.dto.AuthUserDTO;
import uz.pdp.werehouse.model.enums.RoleName;
import uz.pdp.werehouse.model.role.Role;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {


    @GetMapping("/login")
    public ResponseEntity<AuthUserDTO> login() {

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleName(RoleName.ADMIN);
        roles.add(role);

        AuthUserDTO authUserDTO = AuthUserDTO.builder()
                .username("test")
                .fullName("akbar")
                .roles(roles)
                .id("wefwrf")
                .active(true)
                .build();

        return new ResponseEntity<>(authUserDTO, HttpStatus.OK);
    }
}
