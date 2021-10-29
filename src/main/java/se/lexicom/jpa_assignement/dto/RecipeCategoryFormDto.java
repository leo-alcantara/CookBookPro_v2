package se.lexicom.jpa_assignement.dto;

import se.lexicom.jpa_assignement.dto.RecipeDto;

import java.util.List;

public class RecipeCategoryFormDto {

    private String category;
    //@JsonBackReference
    private List<RecipeDto> recipes;

    public RecipeCategoryFormDto() {
    }

    public RecipeCategoryFormDto(String category) {
        this.category = category;
    }

    public RecipeCategoryFormDto(String category, List<RecipeDto> recipes) {
        this.category = category;
        this.recipes = recipes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<RecipeDto> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeDto> recipes) {
        this.recipes = recipes;
    }
}
