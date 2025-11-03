package uz.pdp.werehouse.model.entity;

import jakarta.persistence.Entity;

import uz.pdp.werehouse.model.base.BaseEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Category extends BaseEntity {
    @NotBlank(message = "Category name cannot be blank")
    private String name;
}