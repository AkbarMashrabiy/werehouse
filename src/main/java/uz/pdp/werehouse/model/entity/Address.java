package uz.pdp.werehouse.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.pdp.werehouse.model.base.BaseEntity;
import uz.pdp.werehouse.model.role.Role;
import lombok.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Address extends BaseEntity{
    @NotBlank(message = "Country shouldn't be null")
    private String country;

    @NotBlank(message = "City shouldn't be null")
    private String city;

    @NotBlank(message = "Street shouldn't be null")
    private String street;

    @NotBlank(message = "Home shouldn't be null")
    private String home;

    @NotBlank(message = "Apartment shouldn't be null")
    private String apartment;

    @NotBlank(message = "Zip code shouldn't be null")
    private String zipCode;


}
