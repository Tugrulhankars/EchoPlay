package org.echoplay.echoplay.controller;

import org.echoplay.echoplay.dto.request.CreateCategoryRequest;
import org.echoplay.echoplay.entity.Category;
import org.echoplay.echoplay.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addCategory(@RequestBody CreateCategoryRequest request){
        String response = categoryService.addCategory(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        String response = categoryService.deleteCategory(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categories=categoryService.getAllCategory();
        return  ResponseEntity.ok(categories);
    }
}
