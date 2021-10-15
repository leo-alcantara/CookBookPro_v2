package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.model.RecipeIngredient;
import se.lexicom.jpa_assignement.service.RecipeIngredientService;

import java.util.List;

@RestController
public class RecipeIngredientController {

    private final RecipeIngredientService recipeIngredientService;

    @Autowired
    public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
        this.recipeIngredientService = recipeIngredientService;
    }

    @PostMapping("/api/recipe-ingredient")
    public ResponseEntity<RecipeIngredient> createRecipeIngredient(@RequestBody RecipeIngredient recipeIngredient) {
        RecipeIngredient saved = recipeIngredientService.createRecipeIngredient(recipeIngredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/api/recipe-ingredient/{id}")
    public ResponseEntity<RecipeIngredient> findById(@PathVariable("id") Integer recipeIngredientId) {
        RecipeIngredient foundById = recipeIngredientService.findById(recipeIngredientId);
        return ResponseEntity.ok(foundById);
    }

    @GetMapping("/api/recipe-ingredient")
    public ResponseEntity<List<RecipeIngredient>> findAll() {
        List<RecipeIngredient> allFound = recipeIngredientService.findAll();
        return ResponseEntity.ok(allFound);
    }

    @PutMapping("/api/recipe-ingredient/{id}")
    public ResponseEntity<RecipeIngredient> update(@PathVariable("id") Integer recipeIngredientId,
                                                   @RequestBody RecipeIngredient recipeIngredient) {
        if (recipeIngredientId.equals(recipeIngredient.getRecipeIngredientId())) {
            RecipeIngredient updatedRecipeIngredient = recipeIngredientService.update(recipeIngredient);
            return ResponseEntity.ok().body(updatedRecipeIngredient);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipe-ingredient/{id}")
    public ResponseEntity<RecipeIngredient> delete(@PathVariable("id") RecipeIngredient recipeIngredient) {
        RecipeIngredient deletedRecipeIngredient = recipeIngredientService.delete(recipeIngredient);
        return ResponseEntity.ok(deletedRecipeIngredient);
    }

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipe-ingredient")
    public ResponseEntity<Void> clear() {
        recipeIngredientService.clear();
        return ResponseEntity.ok().build();
    }


}
