package se.lexicom.jpa_assignement.service;

import se.lexicom.jpa_assignement.dto.RecipeIngredientDto;
import se.lexicom.jpa_assignement.dto.RecipeIngredientFormDto;
import se.lexicom.jpa_assignement.entity.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientService {

    RecipeIngredientDto createRecipeIngredient(RecipeIngredientFormDto formDto);

    RecipeIngredientDto findById(Integer recipeIngredientId);

    List<RecipeIngredientDto> findAll();

    RecipeIngredientDto update(RecipeIngredientFormDto formDto);

    RecipeIngredientDto delete(RecipeIngredient recipeIngredient);

    void clear();
}
