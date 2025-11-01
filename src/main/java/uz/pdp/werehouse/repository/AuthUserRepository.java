package uz.pdp.werehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.werehouse.model.entity.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser, String> {
}
