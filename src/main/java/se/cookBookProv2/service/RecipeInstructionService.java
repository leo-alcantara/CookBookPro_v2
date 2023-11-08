package se.cookBookProv2.service;

import se.cookBookProv2.dto.RecipeIngredientDto;
import se.cookBookProv2.dto.RecipeInstructionDto;
import se.cookBookProv2.dto.RecipeInstructionFormDto;
import se.cookBookProv2.entity.RecipeInstruction;

import java.util.List;

public interface RecipeInstructionService {

    RecipeInstructionDto createRecipeInstruction(RecipeInstructionDto recipeInstructionDto);

    RecipeInstructionDto findById(Integer recipeInstructionId);

    List<RecipeInstructionDto> findAll();

    RecipeInstructionDto update(RecipeInstructionDto recipeInstructionDto);

    RecipeInstructionDto delete(RecipeInstruction recipeInstruction);

    void clear();
}
