package uz.pdp.werehouse.model.entity;

import jakarta.persistence.Entity;
import uz.pdp.werehouse.model.base.BaseEntity;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client extends BaseEntity {

    private String name;
    private String phoneNumber;
    private boolean active;
}