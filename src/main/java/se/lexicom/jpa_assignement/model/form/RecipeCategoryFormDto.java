package se.lexicom.jpa_assignement.model.form;

import com.fasterxml.jackson.annotation.JsonBackReference;
import se.lexicom.jpa_assignement.model.Recipe;

import java.util.List;

public class RecipeCategoryFormDto {

    private String category;
    @JsonBackReference
    private List<Recipe> recipes;

    public RecipeCategoryFormDto() {
    }

    public RecipeCategoryFormDto(String category, List<Recipe> recipes) {
        this.category = category;
        this.recipes = recipes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
