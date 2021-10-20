package se.lexicom.jpa_assignement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.model.Recipe;

import java.util.Collection;
import java.util.List;

public interface RecipeController {
    @PostMapping("/api/recipes")
    ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe);

    @GetMapping("/api/recipes/{id}")
    ResponseEntity<Recipe> findById(@PathVariable("id") Integer recipeId);

    @GetMapping("/api/recipes")
    ResponseEntity<List<Recipe>> findAll();

    @PutMapping("/api/recipes/{id}")
    ResponseEntity<Recipe> update(@PathVariable("id") Integer recipeId,
                                  @RequestBody Recipe recipe);

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipes/{id}")
    ResponseEntity<Recipe> delete(@PathVariable("id") Recipe recipe);

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipes")
    ResponseEntity<Void> clear();

    @GetMapping("/api/recipes/{recipe-name}")
    ResponseEntity<List<Recipe>> findRecipeByNameContainsIgnoreCase(@PathVariable("recipe-name") String recipeName);

    @GetMapping("/api/recipes/{ingredient-name}")
    ResponseEntity<List<Recipe>> findRecipeByIngredientNameContainsIgnoreCase(@PathVariable("ingredient-name") String ingredientName);

    @GetMapping("/api/recipes/{category-name}")
    ResponseEntity<List<Recipe>> findRecipeByCategoryContainsIgnoreCase(@PathVariable("category-name") String categoryName);

    @GetMapping("/api/recipes/{recipe-categories}")
    ResponseEntity<List<Recipe>> findRecipeSeveralCategories(@PathVariable("recipe-categories") Collection<String> recipeCategories);
}
