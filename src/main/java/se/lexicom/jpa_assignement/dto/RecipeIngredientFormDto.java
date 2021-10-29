package se.lexicom.jpa_assignement.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import se.lexicom.jpa_assignement.entity.Measurement;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RecipeIngredientFormDto {

    @NotBlank
    @Size(min = 2, max = 50, message = "Exceeded number of characters.")
    private String ingredient;
    private double amount;
    private Measurement measurement;
    @JsonBackReference
    private RecipeFormDto recipe;

    public RecipeIngredientFormDto() {
    }

    public RecipeIngredientFormDto(String ingredient, double amount, Measurement measurement) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
    }

    public RecipeIngredientFormDto(String ingredient, double amount, Measurement measurement, RecipeFormDto recipe) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
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
