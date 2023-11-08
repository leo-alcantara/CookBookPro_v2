package se.cookBookProv2.service;

import se.cookBookProv2.dto.RecipeCategoryDto;
import se.cookBookProv2.dto.RecipeCategoryFormDto;
import se.cookBookProv2.entity.RecipeCategory;

import java.util.List;

public interface RecipeCategoryService {

    RecipeCategoryDto createRecipeCategory(RecipeCategoryDto recipeCategoryDto);

    RecipeCategoryDto findById(Integer recipeCategoryId);

    List<RecipeCategoryDto> findAll();

    RecipeCategoryDto update(RecipeCategoryDto recipeCategoryDto);

    RecipeCategoryDto delete(RecipeCategory recipeCategory);

    void clear();
}
