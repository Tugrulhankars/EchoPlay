package org.echoplay.echoplay.service.impl;

import org.echoplay.echoplay.dto.request.CreateCategoryRequest;
import org.echoplay.echoplay.entity.Category;
import org.echoplay.echoplay.repository.CategoryRepository;
import org.echoplay.echoplay.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String addCategory(CreateCategoryRequest request) {
        Category category = new Category(request.getCategoryName());
        categoryRepository.save(category);
        return "Category added successfully";
    }

    @Override
    public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return "Category deleted successfully";
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categories=categoryRepository.findAll();
        return categories;
    }

    @Override
    public Category getCategoryById(Long id) {
         Category category=categoryRepository.findById(id).get();
        return category;
    }
}
