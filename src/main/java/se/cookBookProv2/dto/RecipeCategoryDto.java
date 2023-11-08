package se.cookBookProv2.dto;

import java.util.List;

public class RecipeCategoryDto {

    private int recipeCategoryId;
    private String category;
    List<RecipeDto> recipes;


    public RecipeCategoryDto() {
    }

    public List<RecipeDto> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeDto> recipes) {
        this.recipes = recipes;
    }

    public RecipeCategoryDto(int recipeCategoryId, String category, List<RecipeDto> recipes) {
        this.recipeCategoryId = recipeCategoryId;
        this.category = category;
        this.recipes = recipes;
    }

    public RecipeCategoryDto(String category) {
        this.category = category;
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

    @Override
    public String toString() {
        return "RecipeCategoryDto{" +
                "recipeCategoryId=" + recipeCategoryId +
                ", category='" + category + '\'' +
                '}';
    }
}
