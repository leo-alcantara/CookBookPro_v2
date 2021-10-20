package se.lexicom.jpa_assignement.form;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import se.lexicom.jpa_assignement.model.RecipeCategory;
import se.lexicom.jpa_assignement.model.RecipeIngredient;
import se.lexicom.jpa_assignement.model.RecipeInstruction;

import java.util.List;

public class RecipeFormDto {

    private String recipeName;
    @JsonManagedReference
    private List<RecipeIngredient> ingredients;
    private RecipeInstruction instructions;
    @JsonManagedReference
    private List<RecipeCategory> categories;

    public RecipeFormDto() {
    }

    public RecipeFormDto(String recipeName, List<RecipeIngredient> ingredients, RecipeInstruction instructions, List<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.categories = categories;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public RecipeInstruction getInstructions() {
        return instructions;
    }

    public void setInstructions(RecipeInstruction instructions) {
        this.instructions = instructions;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }
}
