package se.lexicom.jpa_assignement.controller;

import org.springframework.http.ResponseEntity;
import se.lexicom.jpa_assignement.dto.RecipeInstructionDto;
import se.lexicom.jpa_assignement.model.form.RecipeInstructionFormDto;
import se.lexicom.jpa_assignement.model.RecipeInstruction;

import java.util.List;

public interface RecipeInstructionController {

    ResponseEntity<RecipeInstructionDto> createRecipeInstructions(RecipeInstructionFormDto formDto);

    ResponseEntity<RecipeInstructionDto> findById(Integer recipeInstructionId);

    ResponseEntity<List<RecipeInstructionDto>> findAll();

    ResponseEntity<RecipeInstructionDto> update(RecipeInstructionFormDto formDto);

    ResponseEntity<RecipeInstructionDto> delete(RecipeInstruction recipeInstruction);

    ResponseEntity<Void> clear();
}
