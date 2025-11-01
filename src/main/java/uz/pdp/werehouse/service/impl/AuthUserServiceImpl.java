package uz.pdp.werehouse.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.pdp.werehouse.model.entity.AuthUser;
import uz.pdp.werehouse.repository.AuthUserRepository;
import uz.pdp.werehouse.service.AuthUserService;

@Component
@RequiredArgsConstructor
public class AuthUserServiceImpl implements AuthUserService {
    private final AuthUserRepository authUserRepository;

    @Override
    public boolean isExist(String username) {
        return authUserRepository.existsByUsername(username);
    }

    @Override
    public boolean isActive(String username) {
        return authUserRepository.isActive(username);
    }

    @Override
    public AuthUser getByUsername(String username) {
       return (AuthUser) authUserRepository.findAuthUserByUsername(username);
    }

    @Override
    public AuthUser save(AuthUser authUser) {
        return authUserRepository.save(authUser);
    }

    @Override
    public void delete(String username) {
        AuthUser user = getByUsername(username);
        user.setActive(false);
        save(user);
    }

    @Override
    public boolean isAdmin(String username) {
        AuthUser user = getByUsername(username);
        return user.getRole().getName().equals("ADMIN");
    }

    @Override
    public boolean isUser(String username) {
        AuthUser user = getByUsername(username);
        return user.getRole().getName().equals("USER");
    }

    @Override
    public boolean isManager(String username) {
        AuthUser user = getByUsername(username);
        return user.getRole().getName().equals("MANAGER");
    }

    @Override
    public boolean isCashier(String username) {
        AuthUser user = getByUsername(username);
        return user.getRole().getName().equals("CASHIER");
    }

    @Override
    public boolean isDirector(String username) {
        AuthUser user = getByUsername(username);
        return user.getRole().getName().equals("DIRECTOR");
    }
}
