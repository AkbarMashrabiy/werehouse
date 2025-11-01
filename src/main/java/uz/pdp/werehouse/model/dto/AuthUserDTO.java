package uz.pdp.werehouse.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthUserDTO {
    private String id;
    private String fullName;
    private String username;
    private boolean active;
    private String roleName;
}