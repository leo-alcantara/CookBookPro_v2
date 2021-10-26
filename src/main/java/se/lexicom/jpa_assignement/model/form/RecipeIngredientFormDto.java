package se.lexicom.jpa_assignement.model.form;

import com.fasterxml.jackson.annotation.JsonBackReference;
import se.lexicom.jpa_assignement.model.Ingredient;
import se.lexicom.jpa_assignement.model.Measurement;

public class RecipeIngredientFormDto {

    //Change Type to String
    private Ingredient ingredient;
    private double amount;
    private Measurement measurement;
    @JsonBackReference
    private RecipeFormDto recipe;

    public RecipeIngredientFormDto() {
    }

    public RecipeIngredientFormDto(Ingredient ingredient, double amount, Measurement measurement) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
    }

    public RecipeIngredientFormDto(Ingredient ingredient, double amount, Measurement measurement, RecipeFormDto recipe) {
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

    public RecipeFormDto getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeFormDto recipe) {
        this.recipe = recipe;
    }
}
