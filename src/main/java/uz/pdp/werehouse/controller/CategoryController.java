package uz.pdp.werehouse.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.werehouse.model.dto.CategoryDto;
import uz.pdp.werehouse.model.dto.MyResponse;
import uz.pdp.werehouse.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@RestController ("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping("")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> allCategories = service.getAllCategories();
        if (allCategories == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allCategories);
    }


    @PostMapping("/add")
    public ResponseEntity<MyResponse> createCategory(@RequestBody @Valid CategoryDto categoryDto) {

        MyResponse myResponse = service.addCategory(categoryDto);
        if (myResponse == MyResponse.SUCCESSFULLY_CREATED) {
            return ResponseEntity.ok(myResponse);
        }
        return ResponseEntity.status(400).body(MyResponse.FAILED_TO_CREATE);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") @Valid String id) {
        CategoryDto categoryDto = service.getCategoryById(id);
        if (categoryDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MyResponse> deleteCategory(@PathVariable("id") @Valid String id) {
        return ResponseEntity.ok(service.deleteCategory(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<MyResponse> updateCategory(@PathVariable("id") @Valid String id, @RequestBody @Valid CategoryDto categoryDto) {
        return ResponseEntity.ok(service.updateCategory(id, categoryDto));
    }




}
