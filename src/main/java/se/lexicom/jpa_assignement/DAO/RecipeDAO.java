package se.lexicom.jpa_assignement.DAO;

import se.lexicom.jpa_assignement.entity.Recipe;

import java.util.Collection;
import java.util.List;

public interface RecipeDAO extends GenericCRUDMethods <Recipe, Integer>{

    List<Recipe> findRecipeByNameContainsIgnoreCase(String recipeName);
    List<Recipe> findRecipeByIngredientNameContainsIgnoreCase(String ingredientName);
    List<Recipe> findRecipeByCategoryContainsIgnoreCase(String categoryName);
    List<Recipe> findRecipeSeveralCategories(Collection<String> recipeCategories);
}
