package uz.pdp.werehouse.service;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import uz.pdp.werehouse.model.dto.AuthUserDTO;
import uz.pdp.werehouse.model.dto.LoginDto;
import uz.pdp.werehouse.model.dto.MyResponse;
import uz.pdp.werehouse.model.dto.RegisterDto;
import uz.pdp.werehouse.model.entity.AuthUser;

import java.util.Optional;

@Component
public interface AuthUserService {
    boolean isExist(String username);
    HttpEntity<?> login(LoginDto loginDto);
    MyResponse register(RegisterDto registerDto);
    boolean isActive(String username);
    Optional<AuthUser> getByUsername(String username);
    Optional<AuthUser> save(AuthUser authUser);
    boolean delete(String username);

}
