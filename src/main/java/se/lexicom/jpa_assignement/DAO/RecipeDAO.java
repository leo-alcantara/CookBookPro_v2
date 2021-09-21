package se.lexicom.jpa_assignement.DAO;

import se.lexicom.jpa_assignement.model.Recipe;

import java.util.Collection;
import java.util.List;

public interface RecipeDAO extends GenericCRUDMethods <Recipe, Integer>{

    List<Recipe> findRecipeByName(String recipeName);
    List<Recipe> findRecipeByIngredientName(String ingredientName);
    List<Recipe> findRecipeByCategory(String categoryName);
    List<Recipe> findRecipeSeveralCategories(Collection<String> recipeCategory);
}
