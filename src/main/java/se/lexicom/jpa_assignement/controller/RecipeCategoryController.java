package se.lexicom.jpa_assignement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.model.RecipeCategory;

import java.util.List;

public interface RecipeCategoryController {
    @PostMapping("/api/recipe-category")
    ResponseEntity<RecipeCategory> createRecipeCategory(@RequestBody RecipeCategory recipeCategory);

    @GetMapping("/api/recipe-category/{id}")
    ResponseEntity<RecipeCategory> findById(@PathVariable("id") Integer recipeCategoryId);

    @GetMapping("/api/recipe-category")
    ResponseEntity<List<RecipeCategory>> findAll();

    @PutMapping("/api/recipe-category/{id}")
    ResponseEntity<RecipeCategory> update(@PathVariable("id") Integer recipeCategoryId,
                                          @RequestBody RecipeCategory recipeCategory);

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipe-category/{id}")
    ResponseEntity<RecipeCategory> delete(@PathVariable("id") RecipeCategory recipeCategory);

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipe-category")
    ResponseEntity<Void> clear();
}
