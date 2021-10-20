package se.lexicom.jpa_assignement.form;

import com.fasterxml.jackson.annotation.JsonBackReference;
import se.lexicom.jpa_assignement.model.Ingredient;
import se.lexicom.jpa_assignement.model.Measurement;
import se.lexicom.jpa_assignement.model.Recipe;

public class RecipeIngredientFormDto {

    private Ingredient ingredient;
    private double amount;
    private Measurement measurement;
    @JsonBackReference
    private Recipe recipe;

    public RecipeIngredientFormDto() {
    }

    public RecipeIngredientFormDto(Ingredient ingredient, double amount, Measurement measurement, Recipe recipe) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
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

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
