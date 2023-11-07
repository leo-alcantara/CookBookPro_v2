package se.cookBookProv2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.cookBookProv2.dto.RecipeDto;
import se.cookBookProv2.dto.RecipeFormDto;

import java.util.List;

public interface RecipeController {

    ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeFormDto formDto);

    ResponseEntity<RecipeDto> findById(Integer recipeId);

    ResponseEntity<List<RecipeDto>> find( @RequestParam(name = "search", defaultValue = "all") String search,
                                          @RequestParam(name = "values", defaultValue = "all") String[] values);

    ResponseEntity<RecipeDto> update(RecipeFormDto formDto);

    ResponseEntity<RecipeDto> delete(Integer recipeId);

    ResponseEntity<Void> clear();

}
