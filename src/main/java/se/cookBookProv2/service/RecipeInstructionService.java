package se.cookBookProv2.service;

import se.cookBookProv2.dto.RecipeInstructionDto;
import se.cookBookProv2.dto.RecipeInstructionFormDto;
import se.cookBookProv2.entity.RecipeInstruction;

import java.util.List;

public interface RecipeInstructionService {

    RecipeInstructionDto createRecipeInstruction(RecipeInstructionFormDto formDto);

    RecipeInstructionDto findById(Integer recipeInstructionId);

    List<RecipeInstructionDto> findAll();

    RecipeInstructionDto update(RecipeInstructionFormDto formDto);

    RecipeInstructionDto delete(RecipeInstruction recipeInstruction);

    void clear();
}
