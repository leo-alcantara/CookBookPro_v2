package se.cookBookProv2.service;

import se.cookBookProv2.dto.RecipeDto;
import se.cookBookProv2.dto.RecipeFormDto;

import java.util.Collection;
import java.util.List;

public interface RecipeService {

    RecipeDto createRecipe(RecipeDto recipeDto);

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
