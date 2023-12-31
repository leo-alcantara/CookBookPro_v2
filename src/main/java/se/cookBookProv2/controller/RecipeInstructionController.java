package se.cookBookProv2.controller;

import org.springframework.http.ResponseEntity;
import se.cookBookProv2.dto.RecipeInstructionDto;
import se.cookBookProv2.dto.RecipeInstructionFormDto;
import se.cookBookProv2.entity.RecipeInstruction;

import java.util.List;

public interface RecipeInstructionController {

    ResponseEntity<RecipeInstructionDto> createRecipeInstructions(RecipeInstructionFormDto formDto);

    ResponseEntity<RecipeInstructionDto> findById(Integer recipeInstructionId);

    ResponseEntity<List<RecipeInstructionDto>> findAll();

    ResponseEntity<RecipeInstructionDto> update(RecipeInstructionFormDto formDto);

    ResponseEntity<RecipeInstructionDto> delete(RecipeInstruction recipeInstruction);

    ResponseEntity<Void> clear();
}
