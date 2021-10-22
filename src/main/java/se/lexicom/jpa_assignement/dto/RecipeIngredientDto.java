package se.lexicom.jpa_assignement.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import se.lexicom.jpa_assignement.model.Ingredient;
import se.lexicom.jpa_assignement.model.Measurement;
import se.lexicom.jpa_assignement.model.Recipe;

public class RecipeIngredientDto {

    private int recipeIngredientId;
    private IngredientDto ingredient;
    private double amount;
    private Measurement measurement;
    @JsonBackReference
    private RecipeDto recipe;

    public RecipeIngredientDto() {
    }

    public RecipeIngredientDto(int recipeIngredientId, IngredientDto ingredient, double amount, Measurement measurement, RecipeDto recipe) {
        this.recipeIngredientId = recipeIngredientId;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public int getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public void setRecipeIngredientId(int recipeIngredientId) {
        this.recipeIngredientId = recipeIngredientId;
    }

    public IngredientDto getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientDto ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public RecipeDto getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeDto recipe) {
        this.recipe = recipe;
    }
}
