package se.lexicom.jpa_assignement.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import se.lexicom.jpa_assignement.model.Recipe;

import java.util.List;

public class RecipeCategoryDto {

    private int recipeCategoryId;
    private String category;
    @JsonBackReference
    private List<Recipe> recipes;

    public RecipeCategoryDto() {
    }

    public RecipeCategoryDto(int recipeCategoryId, String category, List<Recipe> recipes) {
        this.recipeCategoryId = recipeCategoryId;
        this.category = category;
        this.recipes = recipes;
    }

    public int getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public void setRecipeCategoryId(int recipeCategoryId) {
        this.recipeCategoryId = recipeCategoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}