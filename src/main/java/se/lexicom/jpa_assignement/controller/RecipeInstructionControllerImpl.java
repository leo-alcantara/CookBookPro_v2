package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.dto.RecipeInstructionDto;
import se.lexicom.jpa_assignement.form.RecipeInstructionFormDto;
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
    public ResponseEntity<RecipeInstructionDto> createRecipeInstructions(@RequestBody RecipeInstructionFormDto formDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeInstructionServiceImpl.createRecipeInstruction(formDto));
    }

    @Override
    @GetMapping("/api/recipe-instructions/{id}")
    public ResponseEntity<RecipeInstructionDto> findById(@PathVariable("id") Integer recipeInstructionId) {
        return ResponseEntity.ok(recipeInstructionServiceImpl.findById(recipeInstructionId));
    }

    @Override
    @GetMapping("/api/recipe-instructions")
    public ResponseEntity<List<RecipeInstructionDto>> findAll() {
        return ResponseEntity.ok(recipeInstructionServiceImpl.findAll());
    }

    @Override
    @PutMapping("/api/recipe-instructions")
    public ResponseEntity<RecipeInstructionDto> update(RecipeInstructionFormDto formDto) {
            return ResponseEntity.ok().body(recipeInstructionServiceImpl.update(formDto));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/recipe-instructions")
    public ResponseEntity<RecipeInstructionDto> delete(@RequestBody RecipeInstruction recipeInstruction) {
        return ResponseEntity.ok(recipeInstructionServiceImpl.delete(recipeInstruction));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/api/recipe-instructions/clear")
    public ResponseEntity<Void> clear() {
        recipeInstructionServiceImpl.clear();
        return ResponseEntity.ok().build();
    }
}
