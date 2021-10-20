package se.lexicom.jpa_assignement.service;

import se.lexicom.jpa_assignement.model.RecipeCategory;

import java.util.List;

public interface RecipeCategoryService {
    RecipeCategory createRecipeCategory(RecipeCategory recipeCategory);

    RecipeCategory findById(Integer recipeCategoryId);

    List<RecipeCategory> findAll();

    RecipeCategory update(RecipeCategory recipeCategory);

    RecipeCategory delete(RecipeCategory recipeCategory);

    void clear();
}
