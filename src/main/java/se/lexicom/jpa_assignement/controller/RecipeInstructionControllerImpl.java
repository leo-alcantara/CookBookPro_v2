package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.dto.RecipeInstructionDto;
import se.lexicom.jpa_assignement.dto.RecipeInstructionFormDto;
import se.lexicom.jpa_assignement.entity.RecipeInstruction;
import se.lexicom.jpa_assignement.service.RecipeInstructionServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/recipe-instructions")
@CrossOrigin("*")
public class RecipeInstructionControllerImpl implements RecipeInstructionController {

    private final RecipeInstructionServiceImpl recipeInstructionServiceImpl;

    @Autowired
    public RecipeInstructionControllerImpl(RecipeInstructionServiceImpl recipeInstructionServiceImpl) {
        this.recipeInstructionServiceImpl = recipeInstructionServiceImpl;
    }

    @Override
    @PostMapping
    public ResponseEntity<RecipeInstructionDto> createRecipeInstructions(@RequestBody @Valid RecipeInstructionFormDto formDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeInstructionServiceImpl.createRecipeInstruction(formDto));
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<RecipeInstructionDto> findById(@PathVariable("id") Integer recipeInstructionId) {
        return ResponseEntity.ok(recipeInstructionServiceImpl.findById(recipeInstructionId));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<RecipeInstructionDto>> findAll() {
        return ResponseEntity.ok(recipeInstructionServiceImpl.findAll());
    }

    @Override
    @PutMapping
    public ResponseEntity<RecipeInstructionDto> update(@RequestBody @Valid RecipeInstructionFormDto formDto) {
        return ResponseEntity.ok().body(recipeInstructionServiceImpl.update(formDto));
    }

    @Override
    @DeleteMapping
    public ResponseEntity<RecipeInstructionDto> delete(@RequestBody RecipeInstruction recipeInstruction) {
        return ResponseEntity.ok(recipeInstructionServiceImpl.delete(recipeInstruction));
    }

    //NOT SURE IF THIS IS RIGHT. IT DOESN'T WORK
    @Override
    @DeleteMapping("/clear")
    public ResponseEntity<Void> clear() {
        recipeInstructionServiceImpl.clear();
        return ResponseEntity.ok().build();
    }
}
