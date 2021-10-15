package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.model.RecipeCategory;
import se.lexicom.jpa_assignement.service.RecipeCategoryService;

import java.util.List;

@RestController
public class RecipeCategoryController {

    private final RecipeCategoryService recipeCategoryService;

    @Autowired
    public RecipeCategoryController(RecipeCategoryService recipeCategoryService) {
        this.recipeCategoryService = recipeCategoryService;
    }

    @PostMapping("/api/recipe-category")
    public ResponseEntity<RecipeCategory> createRecipeCategory(@RequestBody RecipeCategory recipeCategory) {
        RecipeCategory saved = recipeCategoryService.createRecipeCategory(recipeCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/api/recipe-category/{id}")
    public ResponseEntity<RecipeCategory> findById(@PathVariable("id") Integer recipeCategoryId) {
        RecipeCategory foundById = recipeCategoryService.findById(recipeCategoryId);
        return ResponseEntity.ok(foundById);
    }

    @GetMapping("/api/recipe-category")
    public ResponseEntity<List<RecipeCategory>> findAll() {
        List<RecipeCategory> allFound = recipeCategoryService.findAll();
        return ResponseEntity.ok(allFound);
    }

    @PutMapping("/api/recipe-category/{id}")
    public ResponseEntity<RecipeCategory> update(@PathVariable("id") Integer recipeCategoryId,
                                                 @RequestBody RecipeCategory recipeCategory) {
        if (recipeCategoryId.equals(recipeCategory.getRecipeCategoryId())) {
            RecipeCategory updatedRecipeCategory = recipeCategoryService.update(recipeCategory);
            return ResponseEntity.ok().body(updatedRecipeCategory);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipe-category/{id}")
    public ResponseEntity<RecipeCategory> delete(@PathVariable("id") RecipeCategory recipeCategory) {
        RecipeCategory deletedRecipeCategory = recipeCategoryService.delete(recipeCategory);
        return ResponseEntity.ok(deletedRecipeCategory);
    }

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipe-category")
    public ResponseEntity<Void> clear() {
        recipeCategoryService.clear();
        return ResponseEntity.ok().build();
    }
}
