package uz.pdp.werehouse.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.werehouse.mapper.CategoryMapper;
import uz.pdp.werehouse.model.dto.CategoryDto;
import uz.pdp.werehouse.model.dto.MyResponse;
import uz.pdp.werehouse.model.entity.Category;
import uz.pdp.werehouse.repository.CategoryRepository;
import uz.pdp.werehouse.service.CategoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper mapper;
    private final CategoryRepository repository;


    @Override
    public MyResponse addCategory(CategoryDto categoryDto) {
        if (repository.existsByName(categoryDto.getName())){
            return MyResponse.CATEGORY_NAME_ALREADY_EXISTS;
        }
        Category category = mapper.toEntity(categoryDto);
        repository.save(category);
        return MyResponse.SUCCESSFULLY_CREATED;
    }

    @Override
    public CategoryDto getCategoryById(String id) {
        return repository.findById(id).map(mapper::toDTO).orElse(null);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> list = repository.findAll().stream().map(mapper::toDTO).toList();
        if (list.isEmpty()){
            return null;
        }
        return list;
    }

    @Override
    public MyResponse deleteCategory(String id) {
        if (repository.existsById(id)){
            return MyResponse.CATEGORY_NOT_FOUND;
        }
        repository.deleteById(id);
        return MyResponse.SUCCESSFULLY_DELETED;
    }

    @Override
    public MyResponse updateCategory(String id, CategoryDto categoryDto) {
        if (repository.existsById(id)){
            Category category = repository.findById(id).get();
            category.setName(categoryDto.getName());
            repository.save(category);
            return MyResponse.SUCCESSFULLY_UPDATED;
        }
        return MyResponse.CATEGORY_NOT_FOUND;
    }
}
