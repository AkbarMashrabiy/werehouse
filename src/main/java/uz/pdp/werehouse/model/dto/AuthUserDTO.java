package uz.pdp.werehouse.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthUserDTO {
    @NonNull
    private String id;
    @NonNull
    private String fullName;
    @NonNull
    private String username;
    @NonNull
    private Boolean active;
    @NonNull
    private String roleName;
}
