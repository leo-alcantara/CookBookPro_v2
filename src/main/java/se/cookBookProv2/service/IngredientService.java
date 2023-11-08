package se.cookBookProv2.service;

import se.cookBookProv2.dto.IngredientDto;
import se.cookBookProv2.dto.IngredientFormDto;
import se.cookBookProv2.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    IngredientDto createIngredient(IngredientDto ingredientDto);

    IngredientDto findById(Integer ingredientId);

    List<IngredientDto> findAll();

    IngredientDto update(IngredientDto ingredientDto);

    IngredientDto delete(Ingredient ingredient);

    void clear();

    IngredientDto findIngredientByNameContainsIgnoreCase(String ingredientName);
}
