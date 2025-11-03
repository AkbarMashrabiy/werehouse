package uz.pdp.werehouse.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.werehouse.model.role.Role;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultLogin {
    private String message;
    private boolean active;
    private String accessToken;
    private String refreshToken;
    private Set<Role> role;
}