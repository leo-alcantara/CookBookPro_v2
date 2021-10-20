package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.model.RecipeCategory;
import se.lexicom.jpa_assignement.service.RecipeCategoryServiceImpl;

import java.util.List;

@RestController
public class RecipeCategoryControllerImpl implements RecipeCategoryController {

    private final RecipeCategoryServiceImpl recipeCategoryServiceImpl;

    @Autowired
    public RecipeCategoryControllerImpl(RecipeCategoryServiceImpl recipeCategoryServiceImpl) {
        this.recipeCategoryServiceImpl = recipeCategoryServiceImpl;
    }

    @Override
    @PostMapping("/api/recipe-category")
    public ResponseEntity<RecipeCategory> createRecipeCategory(@RequestBody RecipeCategory recipeCategory) {
        RecipeCategory saved = recipeCategoryServiceImpl.createRecipeCategory(recipeCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Override
    @GetMapping("/api/recipe-category/{id}")
    public ResponseEntity<RecipeCategory> findById(@PathVariable("id") Integer recipeCategoryId) {
        RecipeCategory foundById = recipeCategoryServiceImpl.findById(recipeCategoryId);
        return ResponseEntity.ok(foundById);
    }

    @Override
    @GetMapping("/api/recipe-category")
    public ResponseEntity<List<RecipeCategory>> findAll() {
        List<RecipeCategory> allFound = recipeCategoryServiceImpl.findAll();
        return ResponseEntity.ok(allFound);
    }

    @Override
    @PutMapping("/api/recipe-category/{id}")
    public ResponseEntity<RecipeCategory> update(@PathVariable("id") Integer recipeCategoryId,
                                                 @RequestBody RecipeCategory recipeCategory) {
        if (recipeCategoryId.equals(recipeCategory.getRecipeCategoryId())) {
            RecipeCategory updatedRecipeCategory = recipeCategoryServiceImpl.update(recipeCategory);
            return ResponseEntity.ok().body(updatedRecipeCategory);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/recipe-category/{id}")
    public ResponseEntity<RecipeCategory> delete(@PathVariable("id") RecipeCategory recipeCategory) {
        RecipeCategory deletedRecipeCategory = recipeCategoryServiceImpl.delete(recipeCategory);
        return ResponseEntity.ok(deletedRecipeCategory);
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/recipe-category")
    public ResponseEntity<Void> clear() {
        recipeCategoryServiceImpl.clear();
        return ResponseEntity.ok().build();
    }
}
