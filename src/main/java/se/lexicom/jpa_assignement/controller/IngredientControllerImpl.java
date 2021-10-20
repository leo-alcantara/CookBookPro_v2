package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.model.Ingredient;
import se.lexicom.jpa_assignement.service.IngredientServiceImpl;

import java.util.List;

@RestController
public class IngredientControllerImpl implements IngredientController {

    private final IngredientServiceImpl ingredientServiceImpl;

    @Autowired
    public IngredientControllerImpl(IngredientServiceImpl ingredientServiceImpl) {
        this.ingredientServiceImpl = ingredientServiceImpl;
    }

    @Override
    @PostMapping("/api/ingredients")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient saved = ingredientServiceImpl.createIngredient(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Override
    @GetMapping("/api/ingredients/{id}")
    public ResponseEntity<Ingredient> findById(@PathVariable("id") Integer ingredientId) {
        Ingredient foundById = ingredientServiceImpl.findById(ingredientId);
        return ResponseEntity.ok(foundById);
    }

    @Override
    @GetMapping("/api/ingredients")
    public ResponseEntity<List<Ingredient>> findAll() {
        List<Ingredient> allFound = ingredientServiceImpl.findAll();
        return ResponseEntity.ok(allFound);
    }

    @Override
    @PutMapping("/api/ingredients/{id}")
    public ResponseEntity<Ingredient> update(@PathVariable("id") Integer ingredientId,
                                             @RequestBody Ingredient ingredient) {
        if (ingredientId.equals(ingredient.getIngredientId())) {
            Ingredient updatedIngredient = ingredientServiceImpl.update(ingredient);
            return ResponseEntity.ok().body(updatedIngredient);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/ingredients/{id}")
    public ResponseEntity<Ingredient> delete(@PathVariable("id") Ingredient ingredient) {
        Ingredient deletedIngredient = ingredientServiceImpl.delete(ingredient);
        return ResponseEntity.ok(deletedIngredient);
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/ingredients")
    public ResponseEntity<Void> clear() {
        ingredientServiceImpl.clear();
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping("/api/ingredients/{ingredient-name}")
    public ResponseEntity<Ingredient> findIngredientByNameContainsIgnoreCase(@PathVariable("ingredient-name") String ingredientName) {
        Ingredient foundIngredient = ingredientServiceImpl.findIngredientByNameContainsIgnoreCase(ingredientName);
        return ResponseEntity.ok(foundIngredient);
    }


}
