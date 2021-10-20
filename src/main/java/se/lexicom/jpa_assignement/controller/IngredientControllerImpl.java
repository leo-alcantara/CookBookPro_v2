package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.dto.IngredientDto;
import se.lexicom.jpa_assignement.form.IngredientFormDto;
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
    public ResponseEntity<IngredientDto> createIngredient(@RequestBody IngredientFormDto formDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredientServiceImpl.createIngredient(formDto));
    }

    @Override
    @GetMapping("/api/ingredients/{id}")
    public ResponseEntity<IngredientDto> findById(@PathVariable("id") Integer ingredientId) {
        return ResponseEntity.ok(ingredientServiceImpl.findById(ingredientId));
    }

    @Override
    @GetMapping("/api/ingredients")
    public ResponseEntity<List<IngredientDto>> findAll() {
        return ResponseEntity.ok(ingredientServiceImpl.findAll());
    }

    @Override
    @PutMapping("/api/ingredients")
    public ResponseEntity<IngredientDto> update(@RequestBody IngredientFormDto formDto) {
            return ResponseEntity.ok().body(ingredientServiceImpl.update(formDto));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/ingredients")
    public ResponseEntity<IngredientDto> delete(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientServiceImpl.delete(ingredient));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/ingredients/clear")
    public ResponseEntity<Void> clear() {
        ingredientServiceImpl.clear();
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping("/api/ingredients/{ingredient-name}")
    public ResponseEntity<IngredientDto> findIngredientByNameContainsIgnoreCase(@PathVariable("ingredient-name") String ingredientName) {
        return ResponseEntity.ok(ingredientServiceImpl.findIngredientByNameContainsIgnoreCase(ingredientName));
    }


}
