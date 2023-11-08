package se.cookBookProv2.service;

import se.cookBookProv2.dto.RecipeIngredientDto;
import se.cookBookProv2.dto.RecipeIngredientFormDto;
import se.cookBookProv2.entity.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientService {

    RecipeIngredientDto createRecipeIngredient(RecipeIngredientDto recipeIngredientDto);

    RecipeIngredientDto findById(Integer recipeIngredientId);

    List<RecipeIngredientDto> findAll();

    RecipeIngredientDto update(RecipeIngredientDto recipeIngredientDto);

    RecipeIngredientDto delete(RecipeIngredient recipeIngredient);

    void clear();
}
