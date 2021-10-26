package se.lexicom.jpa_assignement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.dto.RecipeDto;
import se.lexicom.jpa_assignement.model.form.RecipeFormDto;
import se.lexicom.jpa_assignement.model.Recipe;

import java.util.Collection;
import java.util.List;

public interface RecipeController {

    ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeFormDto formDto);

    ResponseEntity<RecipeDto> findById(Integer recipeId);

    ResponseEntity<List<RecipeDto>> find( @RequestParam(name = "search", defaultValue = "all") String search,
                                          @RequestParam(name = "values", defaultValue = "all") String[] values);

    ResponseEntity<RecipeDto> update(RecipeFormDto formDto);

    ResponseEntity<RecipeDto> delete(Recipe recipe);

    ResponseEntity<Void> clear();

    /*ResponseEntity<List<RecipeDto>> findRecipeByNameContainsIgnoreCase(String recipeName);

    ResponseEntity<List<RecipeDto>> findRecipeByIngredientNameContainsIgnoreCase(String ingredientName);

    ResponseEntity<List<RecipeDto>> findRecipeByCategoryContainsIgnoreCase(String categoryName);

    ResponseEntity<List<RecipeDto>> findRecipeSeveralCategories(Collection<String> recipeCategories);*/
}
