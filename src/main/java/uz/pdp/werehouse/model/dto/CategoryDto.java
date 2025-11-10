package uz.pdp.werehouse.model.dto;

import lombok.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryDto {
    @NotBlank(message = "Category id cannot be blank")
    private String id;
    @NotBlank(message = "Category name cannot be blank")
    private String name;
}
