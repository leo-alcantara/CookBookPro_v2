package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.model.Recipe;
import se.lexicom.jpa_assignement.service.RecipeServiceImpl;

import java.util.Collection;
import java.util.List;

@RestController
public class RecipeControllerImpl implements RecipeController {

    private final RecipeServiceImpl recipeServiceImpl;

    @Autowired
    public RecipeControllerImpl(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @Override
    @PostMapping("/api/recipes")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe saved = recipeServiceImpl.createRecipe(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Override
    @GetMapping("/api/recipes/{id}")
    public ResponseEntity<Recipe> findById(@PathVariable("id") Integer recipeId) {
        Recipe foundById = recipeServiceImpl.findById(recipeId);
        return ResponseEntity.ok(foundById);
    }

    @Override
    @GetMapping("/api/recipes")
    public ResponseEntity<List<Recipe>> findAll() {
        List<Recipe> allFound = recipeServiceImpl.findAll();
        return ResponseEntity.ok(allFound);
    }

    @Override
    @PutMapping("/api/recipes/{id}")
    public ResponseEntity<Recipe> update(@PathVariable("id") Integer recipeId,
                                         @RequestBody Recipe recipe) {
        if (recipeId.equals(recipe.getRecipeId())) {
            Recipe updatedRecipe = recipeServiceImpl.update(recipe);
            return ResponseEntity.ok().body(updatedRecipe);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/recipes/{id}")
    public ResponseEntity<Recipe> delete(@PathVariable("id") Recipe recipe) {
        Recipe deletedRecipe = recipeServiceImpl.delete(recipe);
        return ResponseEntity.ok(deletedRecipe);
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/recipes")
    public ResponseEntity<Void> clear() {
        recipeServiceImpl.clear();
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping("/api/recipes/{recipe-name}")
    public ResponseEntity<List<Recipe>> findRecipeByNameContainsIgnoreCase(@PathVariable("recipe-name") String recipeName) {
        List<Recipe> foundRecipes = recipeServiceImpl.findRecipeByNameContainsIgnoreCase(recipeName);
        return ResponseEntity.ok(foundRecipes);
    }

    @Override
    @GetMapping("/api/recipes/{ingredient-name}")
    public ResponseEntity<List<Recipe>> findRecipeByIngredientNameContainsIgnoreCase(@PathVariable("ingredient-name") String ingredientName) {
        List<Recipe> foundRecipes = recipeServiceImpl.findRecipeByIngredientNameContainsIgnoreCase(ingredientName);
        return ResponseEntity.ok(foundRecipes);
    }

    @Override
    @GetMapping("/api/recipes/{category-name}")
    public ResponseEntity<List<Recipe>> findRecipeByCategoryContainsIgnoreCase(@PathVariable("category-name") String categoryName) {
        List<Recipe> foundRecipes = recipeServiceImpl.findRecipeByCategoryContainsIgnoreCase(categoryName);
        return ResponseEntity.ok(foundRecipes);
    }

    @Override
    @GetMapping("/api/recipes/{recipe-categories}")
    public ResponseEntity<List<Recipe>> findRecipeSeveralCategories(@PathVariable("recipe-categories") Collection<String> recipeCategories) {
        List<Recipe> foundRecipes = recipeServiceImpl.findRecipeSeveralCategories(recipeCategories);
        return ResponseEntity.ok(foundRecipes);
    }
}
