package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.dto.RecipeCategoryDto;
import se.lexicom.jpa_assignement.form.RecipeCategoryFormDto;
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
    public ResponseEntity<RecipeCategoryDto> createRecipeCategory(@RequestBody RecipeCategoryFormDto formDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeCategoryServiceImpl.createRecipeCategory(formDto));
    }

    @Override
    @GetMapping("/api/recipe-category/{id}")
    public ResponseEntity<RecipeCategoryDto> findById(@PathVariable("id") Integer recipeCategoryId) {
        return ResponseEntity.ok(recipeCategoryServiceImpl.findById(recipeCategoryId));
    }

    @Override
    @GetMapping("/api/recipe-category")
    public ResponseEntity<List<RecipeCategoryDto>> findAll() {
        return ResponseEntity.ok(recipeCategoryServiceImpl.findAll());
    }

    @Override
    @PutMapping("/api/recipe-category")
    public ResponseEntity<RecipeCategoryDto> update(@RequestBody RecipeCategoryFormDto formDto) {
            return ResponseEntity.ok().body(recipeCategoryServiceImpl.update(formDto));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/recipe-category")
    public ResponseEntity<RecipeCategoryDto> delete(@RequestBody RecipeCategory recipeCategory) {
        return ResponseEntity.ok(recipeCategoryServiceImpl.delete(recipeCategory));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/recipe-category/clear")
    public ResponseEntity<Void> clear() {
        recipeCategoryServiceImpl.clear();
        return ResponseEntity.ok().build();
    }
}
