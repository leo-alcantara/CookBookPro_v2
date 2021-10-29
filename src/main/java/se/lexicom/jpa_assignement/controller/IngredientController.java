package se.lexicom.jpa_assignement.controller;

import org.springframework.http.ResponseEntity;
import se.lexicom.jpa_assignement.dto.IngredientDto;
import se.lexicom.jpa_assignement.dto.IngredientFormDto;
import se.lexicom.jpa_assignement.entity.Ingredient;

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
