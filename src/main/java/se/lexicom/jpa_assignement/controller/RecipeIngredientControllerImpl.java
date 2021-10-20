package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.dto.RecipeIngredientDto;
import se.lexicom.jpa_assignement.form.RecipeIngredientFormDto;
import se.lexicom.jpa_assignement.model.RecipeIngredient;
import se.lexicom.jpa_assignement.service.RecipeIngredientServiceImpl;

import java.util.List;

@RestController
public class RecipeIngredientControllerImpl implements RecipeIngredientController {

    private final RecipeIngredientServiceImpl recipeIngredientServiceImpl;

    @Autowired
    public RecipeIngredientControllerImpl(RecipeIngredientServiceImpl recipeIngredientServiceImpl) {
        this.recipeIngredientServiceImpl = recipeIngredientServiceImpl;
    }

    @Override
    @PostMapping("/api/recipe-ingredient")
    public ResponseEntity<RecipeIngredientDto> createRecipeIngredient(@RequestBody RecipeIngredientFormDto formDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeIngredientServiceImpl.createRecipeIngredient(formDto));
    }

    @Override
    @GetMapping("/api/recipe-ingredient/{id}")
    public ResponseEntity<RecipeIngredientDto> findById(@PathVariable("id") Integer recipeIngredientId) {
        return ResponseEntity.ok(recipeIngredientServiceImpl.findById(recipeIngredientId));
    }

    @Override
    @GetMapping("/api/recipe-ingredient")
    public ResponseEntity<List<RecipeIngredientDto>> findAll() {
        return ResponseEntity.ok(recipeIngredientServiceImpl.findAll());
    }

    @Override
    @PutMapping("/api/recipe-ingredient")
    public ResponseEntity<RecipeIngredientDto> update(@RequestBody RecipeIngredientFormDto formDto) {
            return ResponseEntity.ok().body(recipeIngredientServiceImpl.update(formDto));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/recipe-ingredient")
    public ResponseEntity<RecipeIngredientDto> delete(@RequestBody RecipeIngredient recipeIngredient) {
        return ResponseEntity.ok(recipeIngredientServiceImpl.delete(recipeIngredient));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/recipe-ingredient/clear")
    public ResponseEntity<Void> clear() {
        recipeIngredientServiceImpl.clear();
        return ResponseEntity.ok().build();
    }


}
