package se.lexicom.jpa_assignement.repository;

import se.lexicom.jpa_assignement.model.Recipe;
import se.lexicom.jpa_assignement.model.RecipeCategory;

import java.util.Collection;

public interface RecipeDAO extends GenericCRUDMethods <Recipe, Integer>{

    Collection<Recipe> findRecipeByName(String recipeName);
    Collection<Recipe> findRecipeByIngredientName(String ingredientName);
    Collection<Recipe> findRecipeByCategory(RecipeCategory category);
    Collection<Recipe> findRecipeSeveralCategories(Collection<RecipeCategory> recipeCategory);
}
