package uz.pdp.werehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.werehouse.model.role.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
