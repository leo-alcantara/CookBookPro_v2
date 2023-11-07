package se.cookBookProv2.service;

import se.cookBookProv2.dto.RecipeCategoryDto;
import se.cookBookProv2.dto.RecipeCategoryFormDto;
import se.cookBookProv2.entity.RecipeCategory;

import java.util.List;

public interface RecipeCategoryService {

    RecipeCategoryDto createRecipeCategory(RecipeCategoryFormDto form);

    RecipeCategoryDto findById(Integer recipeCategoryId);

    List<RecipeCategoryDto> findAll();

    RecipeCategoryDto update(RecipeCategoryFormDto formDto);

    RecipeCategoryDto delete(RecipeCategory recipeCategory);

    void clear();
}
