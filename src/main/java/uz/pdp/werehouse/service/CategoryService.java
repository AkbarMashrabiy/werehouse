package uz.pdp.werehouse.service;

import uz.pdp.werehouse.model.dto.CategoryDto;
import uz.pdp.werehouse.model.dto.MyResponse;
import uz.pdp.werehouse.model.entity.Category;

import java.util.List;

public interface CategoryService {
    MyResponse addCategory(CategoryDto categoryDto);
    CategoryDto getCategoryById(String id);
    List<CategoryDto> getAllCategories();
    MyResponse deleteCategory(String id);
    MyResponse updateCategory(String id, CategoryDto categoryDto);
}
