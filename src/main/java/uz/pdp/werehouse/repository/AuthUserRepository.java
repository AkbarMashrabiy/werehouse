package uz.pdp.werehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.werehouse.model.entity.AuthUser;

import java.util.List;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, String> {
    List<AuthUser> findAuthUserByUsername(String username);
    boolean isActive(String username);
    boolean existsByUsername(String username);
}
