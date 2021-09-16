package se.lexicom.jpa_assignement.repository;

import se.lexicom.jpa_assignement.model.Recipe;
import se.lexicom.jpa_assignement.model.RecipeCategory;

import java.util.Collection;
import java.util.List;

public interface RecipeDAO extends GenericCRUDMethods <Recipe, Integer>{

    Collection<Recipe> findRecipeByName(String recipeName);
    Collection<Recipe> findRecipeByIngredientName(String ingredientName);
    Collection<Recipe> findRecipeByCategory(String categoryName);
    Collection<Recipe> findRecipeSeveralCategories(Collection<String> recipeCategory);
}
