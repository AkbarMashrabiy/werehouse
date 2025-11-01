package uz.pdp.werehouse.service;

import org.springframework.stereotype.Component;
import uz.pdp.werehouse.model.entity.AuthUser;

import java.util.Optional;

@Component
public interface AuthUserService {
    boolean isExist(String username);
    boolean isActive(String username);
    AuthUser getByUsername(String username);
    AuthUser save(AuthUser authUser);
    void delete(String username);
    boolean isAdmin(String username);
    boolean isUser(String username);
    boolean isManager(String username);
    boolean isCashier(String username);
    boolean isDirector(String username);


}
