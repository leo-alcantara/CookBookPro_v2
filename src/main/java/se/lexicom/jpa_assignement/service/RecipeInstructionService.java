package se.lexicom.jpa_assignement.service;

import se.lexicom.jpa_assignement.dto.RecipeInstructionDto;
import se.lexicom.jpa_assignement.dto.RecipeInstructionFormDto;
import se.lexicom.jpa_assignement.entity.RecipeInstruction;

import java.util.List;

public interface RecipeInstructionService {

    RecipeInstructionDto createRecipeInstruction(RecipeInstructionFormDto formDto);

    RecipeInstructionDto findById(Integer recipeInstructionId);

    List<RecipeInstructionDto> findAll();

    RecipeInstructionDto update(RecipeInstructionFormDto formDto);

    RecipeInstructionDto delete(RecipeInstruction recipeInstruction);

    void clear();
}
