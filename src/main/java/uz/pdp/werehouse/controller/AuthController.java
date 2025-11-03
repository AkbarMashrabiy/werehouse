package uz.pdp.werehouse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.werehouse.model.dto.AuthUserDTO;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {


    @GetMapping("/login")
    public ResponseEntity<AuthUserDTO> login() {

        AuthUserDTO authUserDTO = AuthUserDTO.builder()
                .username("test")
                .fullName("akbar")
                .roleName("ROLE_USER")
                .id("wefwrf")
                .active(true)
                .build();

        return new ResponseEntity<>(authUserDTO, HttpStatus.OK);
    }
}
