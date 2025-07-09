package org.echoplay.echoplay.service;

import org.echoplay.echoplay.dto.request.CreateCategoryRequest;
import org.echoplay.echoplay.entity.Category;

import java.util.List;

public interface CategoryService {

    String addCategory(CreateCategoryRequest request);
    String deleteCategory(Long id);
    List<Category> getAllCategory();
}
