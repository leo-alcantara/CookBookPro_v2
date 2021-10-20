package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.model.RecipeInstruction;
import se.lexicom.jpa_assignement.service.RecipeInstructionServiceImpl;

import java.util.List;

@RestController
public class RecipeInstructionControllerImpl implements RecipeInstructionController {

    private final RecipeInstructionServiceImpl recipeInstructionServiceImpl;

    @Autowired
    public RecipeInstructionControllerImpl(RecipeInstructionServiceImpl recipeInstructionServiceImpl) {
        this.recipeInstructionServiceImpl = recipeInstructionServiceImpl;
    }

    @Override
    @PostMapping("/api/recipe-instructions")
    public ResponseEntity<RecipeInstruction> createRecipeInstructions(@RequestBody RecipeInstruction recipeInstruction) {
        RecipeInstruction saved = recipeInstructionServiceImpl.createRecipeInstruction(recipeInstruction);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Override
    @GetMapping("/api/recipe-instructions/{id}")
    public ResponseEntity<RecipeInstruction> findById(@PathVariable("id") Integer recipeInstructionId) {
        RecipeInstruction foundById = recipeInstructionServiceImpl.findById(recipeInstructionId);
        return ResponseEntity.ok(foundById);
    }

    @Override
    @GetMapping("/api/recipe-instructions")
    public ResponseEntity<List<RecipeInstruction>> findAll() {
        List<RecipeInstruction> allFound = recipeInstructionServiceImpl.findAll();
        return ResponseEntity.ok(allFound);
    }

    @Override
    @PutMapping("/api/recipe-instructions/{id}")
    public ResponseEntity<RecipeInstruction> update(@PathVariable("id") Integer recipeInstructionId,
                                                    @RequestBody RecipeInstruction recipeInstruction) {
        if (recipeInstructionId.equals(recipeInstruction.getRecipeInstructionId())) {
            RecipeInstruction updatedRecipeInstruction = recipeInstructionServiceImpl.update(recipeInstruction);
            return ResponseEntity.ok().body(updatedRecipeInstruction);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/recipe-instructions/{id}")
    public ResponseEntity<RecipeInstruction> delete(@PathVariable("id") RecipeInstruction recipeInstruction) {
        return ResponseEntity.ok(recipeInstructionServiceImpl.delete(recipeInstruction));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/recipe-instructions")
    public ResponseEntity<Void> clear() {
        recipeInstructionServiceImpl.clear();
        return ResponseEntity.ok().build();
    }
}
