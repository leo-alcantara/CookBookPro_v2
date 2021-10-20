package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<RecipeIngredient> createRecipeIngredient(@RequestBody RecipeIngredient recipeIngredient) {
        RecipeIngredient saved = recipeIngredientServiceImpl.createRecipeIngredient(recipeIngredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Override
    @GetMapping("/api/recipe-ingredient/{id}")
    public ResponseEntity<RecipeIngredient> findById(@PathVariable("id") Integer recipeIngredientId) {
        RecipeIngredient foundById = recipeIngredientServiceImpl.findById(recipeIngredientId);
        return ResponseEntity.ok(foundById);
    }

    @Override
    @GetMapping("/api/recipe-ingredient")
    public ResponseEntity<List<RecipeIngredient>> findAll() {
        List<RecipeIngredient> allFound = recipeIngredientServiceImpl.findAll();
        return ResponseEntity.ok(allFound);
    }

    @Override
    @PutMapping("/api/recipe-ingredient/{id}")
    public ResponseEntity<RecipeIngredient> update(@PathVariable("id") Integer recipeIngredientId,
                                                   @RequestBody RecipeIngredient recipeIngredient) {
        if (recipeIngredientId.equals(recipeIngredient.getRecipeIngredientId())) {
            RecipeIngredient updatedRecipeIngredient = recipeIngredientServiceImpl.update(recipeIngredient);
            return ResponseEntity.ok().body(updatedRecipeIngredient);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/recipe-ingredient/{id}")
    public ResponseEntity<RecipeIngredient> delete(@PathVariable("id") RecipeIngredient recipeIngredient) {
        RecipeIngredient deletedRecipeIngredient = recipeIngredientServiceImpl.delete(recipeIngredient);
        return ResponseEntity.ok(deletedRecipeIngredient);
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/recipe-ingredient")
    public ResponseEntity<Void> clear() {
        recipeIngredientServiceImpl.clear();
        return ResponseEntity.ok().build();
    }


}
