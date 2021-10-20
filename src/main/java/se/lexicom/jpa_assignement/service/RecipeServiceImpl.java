package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicom.jpa_assignement.DAO.RecipeDAOImpl;
import se.lexicom.jpa_assignement.model.Recipe;

import java.util.Collection;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeDAOImpl recipeDAO;

    @Autowired
    public RecipeServiceImpl(RecipeDAOImpl recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeDAO.create(recipe);
    }

    @Override
    public Recipe findById(Integer recipeId) {
        return recipeDAO.findById(recipeId);
    }

    @Override
    public List<Recipe> findAll() {
        return recipeDAO.findAll();
    }

    @Override
    public Recipe update(Recipe recipe) {
        return recipeDAO.update(recipe);
    }

    @Override
    public Recipe delete(Recipe recipe) {
        return recipeDAO.delete(recipe);
    }

    @Override
    public void clear() {
        recipeDAO.clear();
    }

    @Override
    public List<Recipe> findRecipeByNameContainsIgnoreCase(String recipeName) {
        return recipeDAO.findRecipeByNameContainsIgnoreCase(recipeName);
    }

    @Override
    public List<Recipe> findRecipeByIngredientNameContainsIgnoreCase(String ingredientName) {
        return recipeDAO.findRecipeByIngredientNameContainsIgnoreCase(ingredientName);
    }

    @Override
    public List<Recipe> findRecipeByCategoryContainsIgnoreCase(String categoryName) {
        return recipeDAO.findRecipeByCategoryContainsIgnoreCase(categoryName);
    }

    @Override
    public List<Recipe> findRecipeSeveralCategories(Collection<String> recipeCategories) {
        return recipeDAO.findRecipeSeveralCategories(recipeCategories);
    }
}
