package se.lexicom.jpa_assignement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.dto.RecipeCategoryDto;
import se.lexicom.jpa_assignement.form.RecipeCategoryFormDto;
import se.lexicom.jpa_assignement.model.RecipeCategory;

import java.util.List;

public interface RecipeCategoryController {

    ResponseEntity<RecipeCategoryDto> createRecipeCategory(RecipeCategoryFormDto formDto);

    ResponseEntity<RecipeCategoryDto> findById(Integer recipeCategoryId);

    ResponseEntity<List<RecipeCategoryDto>> findAll();

    ResponseEntity<RecipeCategoryDto> update(RecipeCategoryFormDto formDto);

    ResponseEntity<RecipeCategoryDto> delete(RecipeCategory recipeCategory);

    ResponseEntity<Void> clear();
}
