package se.lexicom.jpa_assignement.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

public class RecipeDto {

    private int recipeId;
    private String recipeName;
    @JsonManagedReference
    private List<RecipeIngredientDto> ingredients;
    private RecipeInstructionDto instructions;
    private List<RecipeCategoryDto> categories;

    public RecipeDto() {
    }

    public RecipeDto(String recipeName, List<RecipeIngredientDto> ingredients,
                     RecipeInstructionDto instructions, List<RecipeCategoryDto> categories) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.categories = categories;
    }

    public RecipeDto(int recipeId, String recipeName, List<RecipeIngredientDto> ingredients,
                     RecipeInstructionDto instructions, List<RecipeCategoryDto> categories) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.categories = categories;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredientDto> ingredients) {
        this.ingredients = ingredients;
    }

    public RecipeInstructionDto getInstructions() {
        return instructions;
    }

    public void setInstructions(RecipeInstructionDto instructions) {
        this.instructions = instructions;
    }

    public List<RecipeCategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategoryDto> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "RecipeDto{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                ", categories=" + categories +
                '}';
    }
}
