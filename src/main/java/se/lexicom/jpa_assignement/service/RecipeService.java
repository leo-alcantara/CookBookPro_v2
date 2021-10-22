package se.lexicom.jpa_assignement.service;

import se.lexicom.jpa_assignement.dto.RecipeDto;
import se.lexicom.jpa_assignement.model.form.RecipeFormDto;
import se.lexicom.jpa_assignement.model.Recipe;

import java.util.Collection;
import java.util.List;

public interface RecipeService {

    RecipeDto createRecipe(RecipeFormDto formDto);

    RecipeDto findById(Integer recipeId);

    List<RecipeDto> findAll();

    RecipeDto update(RecipeFormDto formDto);

    RecipeDto delete(Recipe recipe);

    void clear();

    List<RecipeDto> findRecipeByNameContainsIgnoreCase(String recipeName);

    List<RecipeDto> findRecipeByIngredientNameContainsIgnoreCase(String ingredientName);

    List<RecipeDto> findRecipeByCategoryContainsIgnoreCase(String categoryName);

    List<RecipeDto> findRecipeSeveralCategories(Collection<String> recipeCategories);
}
