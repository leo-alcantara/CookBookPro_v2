package se.lexicom.jpa_assignement.service;

import se.lexicom.jpa_assignement.model.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientService {
    RecipeIngredient createRecipeIngredient(RecipeIngredient recipeIngredient);

    RecipeIngredient findById(Integer recipeIngredientId);

    List<RecipeIngredient> findAll();

    RecipeIngredient update(RecipeIngredient recipeIngredient);

    RecipeIngredient delete(RecipeIngredient recipeIngredient);

    void clear();
}
