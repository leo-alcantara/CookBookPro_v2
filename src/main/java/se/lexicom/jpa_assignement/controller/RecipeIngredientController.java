package se.lexicom.jpa_assignement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.model.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientController {
    @PostMapping("/api/recipe-ingredient")
    ResponseEntity<RecipeIngredient> createRecipeIngredient(@RequestBody RecipeIngredient recipeIngredient);

    @GetMapping("/api/recipe-ingredient/{id}")
    ResponseEntity<RecipeIngredient> findById(@PathVariable("id") Integer recipeIngredientId);

    @GetMapping("/api/recipe-ingredient")
    ResponseEntity<List<RecipeIngredient>> findAll();

    @PutMapping("/api/recipe-ingredient/{id}")
    ResponseEntity<RecipeIngredient> update(@PathVariable("id") Integer recipeIngredientId,
                                            @RequestBody RecipeIngredient recipeIngredient);

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipe-ingredient/{id}")
    ResponseEntity<RecipeIngredient> delete(@PathVariable("id") RecipeIngredient recipeIngredient);

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipe-ingredient")
    ResponseEntity<Void> clear();
}
