package se.lexicom.jpa_assignement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.model.Ingredient;

import java.util.List;

public interface IngredientController {
    @PostMapping("/api/ingredients")
    ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient);

    @GetMapping("/api/ingredients/{id}")
    ResponseEntity<Ingredient> findById(@PathVariable("id") Integer ingredientId);

    @GetMapping("/api/ingredients")
    ResponseEntity<List<Ingredient>> findAll();

    @PutMapping("/api/ingredients/{id}")
    ResponseEntity<Ingredient> update(@PathVariable("id") Integer ingredientId,
                                      @RequestBody Ingredient ingredient);

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/ingredients/{id}")
    ResponseEntity<Ingredient> delete(@PathVariable("id") Ingredient ingredient);

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/ingredients")
    ResponseEntity<Void> clear();

    @GetMapping("/api/ingredients/{ingredient-name}")
    ResponseEntity<Ingredient> findIngredientByNameContainsIgnoreCase(@PathVariable("ingredient-name") String ingredientName);
}
