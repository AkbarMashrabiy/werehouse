package uz.pdp.werehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.werehouse.model.dto.LoginDto;
import uz.pdp.werehouse.model.dto.MyResponse;
import uz.pdp.werehouse.model.dto.RegisterDto;
import uz.pdp.werehouse.model.entity.AuthUser;
import uz.pdp.werehouse.security.JwtProvider;
import uz.pdp.werehouse.service.impl.AuthUserServiceImpl;
import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthUserServiceImpl service;
    private final JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDto loginDto) {
        return service.login(loginDto);
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDto registerDto) {
        MyResponse register = service.register(registerDto);
        if (register == MyResponse.SUCCESSFULLY_CREATED) {
            return ResponseEntity.ok(register);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(register);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        String username = jwtProvider.extractUsername(refreshToken);
        Optional<AuthUser> authUser = service.getByUsername(username);
        if (authUser.isPresent() && jwtProvider.isTokenValid(refreshToken, authUser.get())){
            String newAccessToken = jwtProvider.generateAccessToken(authUser.get());
            return ResponseEntity.ok(Map.of("accessToken", newAccessToken));
        }
        return ResponseEntity.status(401).body("Invalid refresh token");
    }
    @DeleteMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam("username") String username) {
        return service.delete(username) ? ResponseEntity.ok().build() : ResponseEntity.status(401).build();
    }

    @PreAuthorize("hasAnyRole('ADMIN' , 'DIRECTOR')")
    @GetMapping("/test")
    public ResponseEntity<String> test(@RequestBody String test) {
        return new ResponseEntity<>(test, HttpStatus.OK);
    }



}
