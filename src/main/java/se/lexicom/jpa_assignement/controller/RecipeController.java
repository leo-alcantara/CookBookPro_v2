package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.model.Recipe;
import se.lexicom.jpa_assignement.service.RecipeService;

import java.util.Collection;
import java.util.List;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/api/recipes")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe saved = recipeService.createRecipe(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/api/recipes/{id}")
    public ResponseEntity<Recipe> findById(@PathVariable("id") Integer recipeId) {
        Recipe foundById = recipeService.findById(recipeId);
        return ResponseEntity.ok(foundById);
    }

    @GetMapping("/api/recipes")
    public ResponseEntity<List<Recipe>> findAll() {
        List<Recipe> allFound = recipeService.findAll();
        return ResponseEntity.ok(allFound);
    }

    @PutMapping("/api/recipes/{id}")
    public ResponseEntity<Recipe> update(@PathVariable("id") Integer recipeId,
                                         @RequestBody Recipe recipe) {
        if (recipeId.equals(recipe.getRecipeId())) {
            Recipe updatedRecipe = recipeService.update(recipe);
            return ResponseEntity.ok().body(updatedRecipe);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipes/{id}")
    public ResponseEntity<Recipe> delete(@PathVariable("id") Recipe recipe) {
        Recipe deletedRecipe = recipeService.delete(recipe);
        return ResponseEntity.ok(deletedRecipe);
    }

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipes")
    public ResponseEntity<Void> clear() {
        recipeService.clear();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/recipes/{recipe-name}")
    public ResponseEntity<List<Recipe>> findRecipeByNameContainsIgnoreCase(@PathVariable("recipe-name") String recipeName) {
        List<Recipe> foundRecipes = recipeService.findRecipeByNameContainsIgnoreCase(recipeName);
        return ResponseEntity.ok(foundRecipes);
    }

    @GetMapping("/api/recipes/{ingredient-name}")
    public ResponseEntity<List<Recipe>> findRecipeByIngredientNameContainsIgnoreCase(@PathVariable("ingredient-name") String ingredientName) {
        List<Recipe> foundRecipes = recipeService.findRecipeByIngredientNameContainsIgnoreCase(ingredientName);
        return ResponseEntity.ok(foundRecipes);
    }

    @GetMapping("/api/recipes/{category-name}")
    public ResponseEntity<List<Recipe>> findRecipeByCategoryContainsIgnoreCase(@PathVariable("category-name") String categoryName) {
        List<Recipe> foundRecipes = recipeService.findRecipeByCategoryContainsIgnoreCase(categoryName);
        return ResponseEntity.ok(foundRecipes);
    }

    @GetMapping("/api/recipes/{recipe-categories}")
    public ResponseEntity<List<Recipe>> findRecipeSeveralCategories(@PathVariable("recipe-categories") Collection<String> recipeCategories) {
        List<Recipe> foundRecipes = recipeService.findRecipeSeveralCategories(recipeCategories);
        return ResponseEntity.ok(foundRecipes);
    }
}
