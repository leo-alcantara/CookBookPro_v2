package se.lexicom.jpa_assignement.service;

import se.lexicom.jpa_assignement.dto.RecipeDto;
import se.lexicom.jpa_assignement.dto.RecipeFormDto;
import se.lexicom.jpa_assignement.entity.Recipe;

import java.util.Collection;
import java.util.List;

public interface RecipeService {

    RecipeDto createRecipe(RecipeFormDto formDto);

    RecipeDto findById(Integer recipeId);

    List<RecipeDto> findAll();

    RecipeDto update(RecipeFormDto formDto);

    RecipeDto delete(Integer recipeId);

    void clear();

    List<RecipeDto> findRecipeByNameContainsIgnoreCase(String recipeName);

    List<RecipeDto> findRecipeByIngredientNameContainsIgnoreCase(String ingredientName);

    List<RecipeDto> findRecipeByCategoryContainsIgnoreCase(String categoryName);

    List<RecipeDto> findRecipeSeveralCategories(Collection<String> recipeCategories);
}
