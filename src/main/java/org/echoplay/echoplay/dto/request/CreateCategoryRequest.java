package org.echoplay.echoplay.dto.request;

public class CreateCategoryRequest {
    private String categoryName;

    public CreateCategoryRequest(String categoryName) {
        this.categoryName = categoryName;
    }

    public CreateCategoryRequest() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
