package uz.pdp.werehouse.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.werehouse.model.dto.LoginDto;
import uz.pdp.werehouse.model.dto.MyResponse;
import uz.pdp.werehouse.model.dto.RegisterDto;
import uz.pdp.werehouse.model.dto.ResultLogin;
import uz.pdp.werehouse.model.entity.AuthUser;
import uz.pdp.werehouse.model.role.Role;
import uz.pdp.werehouse.repository.AuthUserRepository;
import uz.pdp.werehouse.repository.RoleRepository;
import uz.pdp.werehouse.security.JwtProvider;
import uz.pdp.werehouse.service.AuthUserService;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AuthUserServiceImpl implements AuthUserService {
    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Override
    public boolean isExist(String username) {
        return authUserRepository.existsByUsername(username);
    }

    @Override
    public ResponseEntity<?> login(LoginDto loginDto) {
        Optional<AuthUser> byUsername = authUserRepository.findAuthUserByUsername(loginDto.getUsername());
        if (byUsername.isPresent()) {
            AuthUser authUser = byUsername.get();
            if (passwordEncoder.matches(loginDto.getPassword(), authUser.getPassword())) {
                String accessToken = jwtProvider.generateAccessToken(authUser);
                String refreshToken = jwtProvider.generateRefreshToken(authUser);

                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                authUser.getUsername(),
                                loginDto.getPassword(),
                                authUser.getAuthorities()
                        )
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);

                AuthUser user = (AuthUser) authentication.getPrincipal();

                return ResponseEntity.ok(
                        new ResultLogin(
                                "Successfully login",
                                true,
                                accessToken,
                                refreshToken,
                                user.getRoles()
                        )
                );
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyResponse.WRONG_PASSWORD);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MyResponse.USER_NOT_FOUND);
    }

    @Override
    public MyResponse register(RegisterDto registerDto) {
        if (authUserRepository.existsByUsername(registerDto.getUsername())) {
            return MyResponse.USERNAME_EXISTS;
        }
        if (authUserRepository.existsByFullName(registerDto.getFullName())) {
            return MyResponse.FULL_NAME_EXISTS;
        }
        final Optional<Role> byId = roleRepository.findById(registerDto.getRole_id());
        if (byId.isPresent()) {
            final Role role = byId.get();
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            AuthUser authUser = new AuthUser(
                    registerDto.getFullName(),
                    registerDto.getUsername(),
                    passwordEncoder.encode(registerDto.getPassword()),
                    true,
                    roles
            );
            authUserRepository.save(authUser);
            return MyResponse.SUCCESSFULLY_CREATED;
        }
        return MyResponse.ROLE_NOT_FOUND;
    }


    @Override
    public boolean isActive(String username) {
        return authUserRepository.existsByUsernameAndActiveTrue(username);
    }

    @Override
    public Optional<AuthUser> getByUsername(String username) {
        return authUserRepository.findAuthUserByUsername(username);
    }

    @Override
    public Optional<AuthUser> save(AuthUser authUser) {
        return Optional.of(authUserRepository.save(authUser));
    }

    @Override
    public boolean delete(String username) {
        Optional<AuthUser> user = getByUsername(username);
        if (user.isPresent()) {
            user.get().setActive(false);
            save(user.get());
            return true;
        }
        return false;
    }

}
