package se.cookBookProv2.service;

import se.cookBookProv2.dto.RecipeIngredientDto;
import se.cookBookProv2.dto.RecipeIngredientFormDto;
import se.cookBookProv2.entity.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientService {

    RecipeIngredientDto createRecipeIngredient(RecipeIngredientFormDto formDto);

    RecipeIngredientDto findById(Integer recipeIngredientId);

    List<RecipeIngredientDto> findAll();

    RecipeIngredientDto update(RecipeIngredientFormDto formDto);

    RecipeIngredientDto delete(RecipeIngredient recipeIngredient);

    void clear();
}
