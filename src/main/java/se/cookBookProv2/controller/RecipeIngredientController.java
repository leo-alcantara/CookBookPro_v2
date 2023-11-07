package se.cookBookProv2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.cookBookProv2.dto.RecipeIngredientDto;
import se.cookBookProv2.dto.RecipeIngredientFormDto;
import se.cookBookProv2.entity.RecipeIngredient;

import java.util.List;

public interface RecipeIngredientController {

    ResponseEntity<RecipeIngredientDto> createRecipeIngredient(RecipeIngredientFormDto formDto);

    ResponseEntity<RecipeIngredientDto> findById(Integer recipeIngredientId);

    ResponseEntity<List<RecipeIngredientDto>> findAll();

    ResponseEntity<RecipeIngredientDto> update(@RequestBody RecipeIngredientFormDto formDto);

    ResponseEntity<RecipeIngredientDto> delete(RecipeIngredient recipeIngredient);

    ResponseEntity<Void> clear();
}
