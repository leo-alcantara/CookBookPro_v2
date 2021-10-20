package se.lexicom.jpa_assignement.service;

import se.lexicom.jpa_assignement.model.RecipeInstruction;

import java.util.List;

public interface RecipeInstructionService {
    RecipeInstruction createRecipeInstruction(RecipeInstruction recipeInstruction);

    RecipeInstruction findById(Integer recipeInstructionId);

    List<RecipeInstruction> findAll();

    RecipeInstruction update(RecipeInstruction recipeInstruction);

    RecipeInstruction delete(RecipeInstruction recipeInstruction);

    void clear();
}
