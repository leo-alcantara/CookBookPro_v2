package se.cookBookProv2.controller;

import org.springframework.http.ResponseEntity;
import se.cookBookProv2.dto.IngredientDto;
import se.cookBookProv2.dto.IngredientFormDto;
import se.cookBookProv2.entity.Ingredient;

import java.util.List;

public interface IngredientController {


    ResponseEntity<IngredientDto> createIngredient(IngredientFormDto formDto);

    ResponseEntity<IngredientDto> findById(Integer ingredientId);

    ResponseEntity<List<IngredientDto>> findAll();

    ResponseEntity<IngredientDto> update(IngredientFormDto formDto);

    ResponseEntity<IngredientDto> delete(Ingredient ingredient);

    ResponseEntity<Void> clear();

    ResponseEntity<IngredientDto> findIngredientByNameContainsIgnoreCase(String ingredientName);
}
