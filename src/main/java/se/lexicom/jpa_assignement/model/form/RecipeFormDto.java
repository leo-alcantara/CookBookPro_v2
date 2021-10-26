package se.lexicom.jpa_assignement.model.form;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

public class RecipeFormDto {

    private String recipeName;
    @JsonManagedReference
    private List<RecipeIngredientFormDto> ingredients;
    //Change type to string
    private String instructions;
    @JsonManagedReference
    //Change type to String
    private String categories;

    public RecipeFormDto() {
    }

    public RecipeFormDto(String recipeName, List<RecipeIngredientFormDto> ingredients, String instructions, String categories) {
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

    public List<RecipeIngredientFormDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredientFormDto> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}



