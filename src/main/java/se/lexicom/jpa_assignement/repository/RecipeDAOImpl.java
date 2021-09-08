package se.lexicom.jpa_assignement.repository;

import se.lexicom.jpa_assignement.model.Recipe;
import se.lexicom.jpa_assignement.model.RecipeCategory;

import java.util.Collection;

public class RecipeDAOImpl implements RecipeDAO {


    @Override
    public Recipe create(Recipe recipe) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public Collection<Recipe> findAll() {
        return null;
    }

    @Override
    public Recipe findById(Integer integer) {
        return null;
    }

    @Override
    public boolean update(Recipe recipe) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Collection<Recipe> findRecipeByName(String recipeName) {
        return null;
    }

    @Override
    public Collection<Recipe> findRecipeByIngredientName(String ingredientName) {
        return null;
    }

    @Override
    public Collection<Recipe> findRecipeByCategory(RecipeCategory category) {
        return null;
    }

    @Override
    public Collection<Recipe> findRecipeSeveralCategories() {
        return null;
    }
}
