package se.lexicom.jpa_assignement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.dto.RecipeIngredientDto;
import se.lexicom.jpa_assignement.dto.RecipeIngredientFormDto;
import se.lexicom.jpa_assignement.entity.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientController {

    ResponseEntity<RecipeIngredientDto> createRecipeIngredient(RecipeIngredientFormDto formDto);

    ResponseEntity<RecipeIngredientDto> findById(Integer recipeIngredientId);

    ResponseEntity<List<RecipeIngredientDto>> findAll();

    ResponseEntity<RecipeIngredientDto> update(@RequestBody RecipeIngredientFormDto formDto);

    ResponseEntity<RecipeIngredientDto> delete(RecipeIngredient recipeIngredient);

    ResponseEntity<Void> clear();
}
