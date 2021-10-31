package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.dto.RecipeCategoryDto;
import se.lexicom.jpa_assignement.dto.RecipeCategoryFormDto;
import se.lexicom.jpa_assignement.entity.RecipeCategory;
import se.lexicom.jpa_assignement.service.RecipeCategoryServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recipe-category")
@CrossOrigin("*")
public class RecipeCategoryControllerImpl implements RecipeCategoryController {

    private final RecipeCategoryServiceImpl recipeCategoryServiceImpl;

    @Autowired
    public RecipeCategoryControllerImpl(RecipeCategoryServiceImpl recipeCategoryServiceImpl) {
        this.recipeCategoryServiceImpl = recipeCategoryServiceImpl;
    }

    @Override
    @PostMapping
    public ResponseEntity<RecipeCategoryDto> createRecipeCategory(@RequestBody @Valid RecipeCategoryFormDto formDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeCategoryServiceImpl.createRecipeCategory(formDto));
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<RecipeCategoryDto> findById(@PathVariable("id") Integer recipeCategoryId) {
        return ResponseEntity.ok(recipeCategoryServiceImpl.findById(recipeCategoryId));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<RecipeCategoryDto>> findAll() {
        return ResponseEntity.ok(recipeCategoryServiceImpl.findAll());
    }

    @Override
    @PutMapping
    public ResponseEntity<RecipeCategoryDto> update(@RequestBody @Valid RecipeCategoryFormDto formDto) {
            return ResponseEntity.ok().body(recipeCategoryServiceImpl.update(formDto));
    }

    @Override
    @DeleteMapping
    public ResponseEntity<RecipeCategoryDto> delete(@RequestBody RecipeCategory recipeCategory) {
        return ResponseEntity.ok(recipeCategoryServiceImpl.delete(recipeCategory));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/clear")
    public ResponseEntity<Void> clear() {
        recipeCategoryServiceImpl.clear();
        return ResponseEntity.ok().build();
    }
}
