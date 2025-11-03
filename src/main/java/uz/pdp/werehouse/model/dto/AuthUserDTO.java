package uz.pdp.werehouse.model.dto;

import lombok.*;
import uz.pdp.werehouse.model.role.Role;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthUserDTO {
    @NotBlank(message = "id cannot be null")
    private String id;
    @NotBlank(message = "fullName cannot be null")
    private String fullName;
    @NotBlank(message = "username cannot be null")
    private String username;
    private boolean active = true;
    @NotBlank(message = "roleName cannot be null")
    private Set<Role> roles;
}
