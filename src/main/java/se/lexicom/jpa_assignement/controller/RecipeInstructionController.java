package se.lexicom.jpa_assignement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.model.RecipeInstruction;

import java.util.List;

public interface RecipeInstructionController {
    @PostMapping("/api/recipe-instructions")
    ResponseEntity<RecipeInstruction> createRecipeInstructions(@RequestBody RecipeInstruction recipeInstruction);

    @GetMapping("/api/recipe-instructions/{id}")
    ResponseEntity<RecipeInstruction> findById(@PathVariable("id") Integer recipeInstructionId);

    @GetMapping("/api/recipe-instructions")
    ResponseEntity<List<RecipeInstruction>> findAll();

    @PutMapping("/api/recipe-instructions/{id}")
    ResponseEntity<RecipeInstruction> update(@PathVariable("id") Integer recipeInstructionId,
                                             @RequestBody RecipeInstruction recipeInstruction);

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipe-instructions/{id}")
    ResponseEntity<RecipeInstruction> delete(@PathVariable("id") RecipeInstruction recipeInstruction);

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipe-instructions")
    ResponseEntity<Void> clear();
}
