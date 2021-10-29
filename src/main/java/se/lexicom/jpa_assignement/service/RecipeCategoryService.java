package se.lexicom.jpa_assignement.service;

import se.lexicom.jpa_assignement.dto.RecipeCategoryDto;
import se.lexicom.jpa_assignement.dto.RecipeCategoryFormDto;
import se.lexicom.jpa_assignement.entity.RecipeCategory;

import java.util.List;

public interface RecipeCategoryService {

    RecipeCategoryDto createRecipeCategory(RecipeCategoryFormDto form);

    RecipeCategoryDto findById(Integer recipeCategoryId);

    List<RecipeCategoryDto> findAll();

    RecipeCategoryDto update(RecipeCategoryFormDto formDto);

    RecipeCategoryDto delete(RecipeCategory recipeCategory);

    void clear();
}
