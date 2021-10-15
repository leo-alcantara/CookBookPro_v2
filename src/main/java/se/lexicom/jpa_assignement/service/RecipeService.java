package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicom.jpa_assignement.DAO.RecipeDAOImpl;
import se.lexicom.jpa_assignement.model.Recipe;

import java.util.Collection;
import java.util.List;

@Service
public class RecipeService {

    private final RecipeDAOImpl recipeDAO;

    @Autowired
    public RecipeService(RecipeDAOImpl recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeDAO.create(recipe);
    }

    public Recipe findById(Integer recipeId) {
        return recipeDAO.findById(recipeId);
    }

    public List<Recipe> findAll() {
        return recipeDAO.findAll();
    }

    public Recipe update(Recipe recipe) {
        return recipeDAO.update(recipe);
    }

    public Recipe delete(Recipe recipe) {
        return recipeDAO.delete(recipe);
    }

    public void clear() {
        recipeDAO.clear();
    }

    public List<Recipe> findRecipeByNameContainsIgnoreCase(String recipeName) {
        return recipeDAO.findRecipeByNameContainsIgnoreCase(recipeName);
    }

    public List<Recipe> findRecipeByIngredientNameContainsIgnoreCase(String ingredientName) {
        return recipeDAO.findRecipeByIngredientNameContainsIgnoreCase(ingredientName);
    }

    public List<Recipe> findRecipeByCategoryContainsIgnoreCase(String categoryName) {
        return recipeDAO.findRecipeByCategoryContainsIgnoreCase(categoryName);
    }

    public List<Recipe> findRecipeSeveralCategories(Collection<String> recipeCategories) {
        return recipeDAO.findRecipeSeveralCategories(recipeCategories);
    }
}
