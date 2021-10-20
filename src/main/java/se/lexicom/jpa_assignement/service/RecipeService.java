package se.lexicom.jpa_assignement.service;

import se.lexicom.jpa_assignement.model.Recipe;

import java.util.Collection;
import java.util.List;

public interface RecipeService {
    Recipe createRecipe(Recipe recipe);

    Recipe findById(Integer recipeId);

    List<Recipe> findAll();

    Recipe update(Recipe recipe);

    Recipe delete(Recipe recipe);

    void clear();

    List<Recipe> findRecipeByNameContainsIgnoreCase(String recipeName);

    List<Recipe> findRecipeByIngredientNameContainsIgnoreCase(String ingredientName);

    List<Recipe> findRecipeByCategoryContainsIgnoreCase(String categoryName);

    List<Recipe> findRecipeSeveralCategories(Collection<String> recipeCategories);
}
