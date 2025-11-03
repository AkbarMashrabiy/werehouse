package uz.pdp.werehouse.model.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterDto {
    @NotBlank(message = "fullName cannot be null")
    private String fullName;
    @NotBlank(message = "username cannot be null")
    private String username;
    @NotBlank(message = "password cannot be null")
    private String password;
    @NotBlank(message = "roleName cannot be null")
    private String role_id;
}
