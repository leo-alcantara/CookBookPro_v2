package se.cookBookProv2.controller;

import org.springframework.http.ResponseEntity;
import se.cookBookProv2.dto.RecipeCategoryDto;
import se.cookBookProv2.dto.RecipeCategoryFormDto;
import se.cookBookProv2.entity.RecipeCategory;

import java.util.List;

public interface RecipeCategoryController {

    ResponseEntity<RecipeCategoryDto> createRecipeCategory(RecipeCategoryDto recipeCategoryDto);

    ResponseEntity<RecipeCategoryDto> findById(Integer recipeCategoryId);

    ResponseEntity<List<RecipeCategoryDto>> findAll();

    ResponseEntity<RecipeCategoryDto> update(RecipeCategoryDto recipeCategoryDto);

    ResponseEntity<RecipeCategoryDto> delete(RecipeCategory recipeCategory);

    ResponseEntity<Void> clear();
}
