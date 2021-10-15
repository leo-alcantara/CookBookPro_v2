package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.model.RecipeInstruction;
import se.lexicom.jpa_assignement.service.RecipeInstructionService;

import java.util.List;

@RestController
public class RecipeInstructionController {

    private final RecipeInstructionService recipeInstructionService;

    @Autowired
    public RecipeInstructionController(RecipeInstructionService recipeInstructionService) {
        this.recipeInstructionService = recipeInstructionService;
    }

    @PostMapping("/api/recipe-instructions")
    public ResponseEntity<RecipeInstruction> createRecipeInstructions(@RequestBody RecipeInstruction recipeInstruction) {
        RecipeInstruction saved = recipeInstructionService.createRecipeInstruction(recipeInstruction);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/api/recipe-instructions/{id}")
    public ResponseEntity<RecipeInstruction> findById(@PathVariable("id") Integer recipeInstructionId) {
        RecipeInstruction foundById = recipeInstructionService.findById(recipeInstructionId);
        return ResponseEntity.ok(foundById);
    }

    @GetMapping("/api/recipe-instructions")
    public ResponseEntity<List<RecipeInstruction>> findAll() {
        List<RecipeInstruction> allFound = recipeInstructionService.findAll();
        return ResponseEntity.ok(allFound);
    }

    @PutMapping("/api/recipe-instructions/{id}")
    public ResponseEntity<RecipeInstruction> update(@PathVariable("id") Integer recipeInstructionId,
                                                    @RequestBody RecipeInstruction recipeInstruction) {
        if (recipeInstructionId.equals(recipeInstruction.getRecipeInstructionId())) {
            RecipeInstruction updatedRecipeInstruction = recipeInstructionService.update(recipeInstruction);
            return ResponseEntity.ok().body(updatedRecipeInstruction);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipe-instructions/{id}")
    public ResponseEntity<RecipeInstruction> delete(@PathVariable("id") RecipeInstruction recipeInstruction) {
        RecipeInstruction deletedRecipeInstruction = recipeInstructionService.delete(recipeInstruction);
        return ResponseEntity.ok(deletedRecipeInstruction);
    }

    //NOT SURE IF THIS IS RIGHT
    @DeleteMapping("/api/recipe-instructions")
    public ResponseEntity<Void> clear() {
        recipeInstructionService.clear();
        return ResponseEntity.ok().build();
    }
}
