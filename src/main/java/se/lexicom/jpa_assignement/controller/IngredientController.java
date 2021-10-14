package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.model.Ingredient;
import se.lexicom.jpa_assignement.service.IngredientService;

import java.util.List;

@RestController
public class IngredientController {

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/api/ingredients")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient){
        Ingredient saved=ingredientService.createIngredient(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/api/ingredients/{id}")
    public ResponseEntity<Ingredient> findById(@PathVariable("id") Integer ingredientId){
        Ingredient foundById=ingredientService.findById(ingredientId);
        return ResponseEntity.ok(foundById);
    }

    @GetMapping("/api/ingredients")
    public ResponseEntity<List<Ingredient>> findAll(){
        List<Ingredient> allFound=ingredientService.findAll();
         return ResponseEntity.ok(allFound);
    }

    @PutMapping("/api/ingredients/{id}")
    public ResponseEntity<Ingredient> update(@PathVariable("id") Integer ingredientId,
                                             @RequestBody Ingredient ingredient){
        if(ingredientId.equals(ingredient.getIngredientId())){
            Ingredient updatedIngredient=ingredientService.update(ingredient);
            return ResponseEntity.ok().body(updatedIngredient);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/ingredients/{id}")
    public ResponseEntity<Ingredient> delete(@PathVariable("id") Ingredient ingredient){
        Ingredient deletedIngredient= ingredientService.delete(ingredient);
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/api/ingredients")
    public ResponseEntity<Void> clear(){
        ingredientService.clear();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/ingredients/{ingredientName}")
    public ResponseEntity<Ingredient> findIngredientByNameContainsIgnoreCase(@PathVariable("ingredientName") String ingredientName){
        Ingredient foundIngredient=ingredientService.findIngredientByNameContainsIgnoreCase(ingredientName);
        return ResponseEntity.ok(foundIngredient);
    }



}
