package uz.pdp.werehouse.mapper;

import org.springframework.stereotype.Component;
import uz.pdp.werehouse.model.dto.CategoryDto;
import uz.pdp.werehouse.model.entity.Category;

@Component
public class CategoryMapper {

    public  Category toEntity(CategoryDto dto) {
        Category entity = new Category();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }
    public CategoryDto toDTO(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

}
