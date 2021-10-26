package se.lexicom.jpa_assignement.model.form;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import se.lexicom.jpa_assignement.model.RecipeCategory;
import se.lexicom.jpa_assignement.model.RecipeIngredient;
import se.lexicom.jpa_assignement.model.RecipeInstruction;

import java.util.List;

public class RecipeFormDto {

    private String recipeName;
    @JsonManagedReference
    private List<RecipeIngredientFormDto> ingredients;
    //Change type to string
    private RecipeInstructionFormDto instructions;
    @JsonManagedReference
    //Change type to String
    private List<RecipeCategoryFormDto> categories;

    public RecipeFormDto() {
    }

    public RecipeFormDto(String recipeName, List<RecipeIngredientFormDto> ingredients, RecipeInstructionFormDto instructions, List<RecipeCategoryFormDto> categories) {
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

    public RecipeInstructionFormDto getInstructions() {
        return instructions;
    }

    public void setInstructions(RecipeInstructionFormDto instructions) {
        this.instructions = instructions;
    }

    public List<RecipeCategoryFormDto> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategoryFormDto> categories) {
        this.categories = categories;
    }
}
