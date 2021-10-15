package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicom.jpa_assignement.DAO.RecipeIngredientDAOImpl;
import se.lexicom.jpa_assignement.model.RecipeIngredient;

import java.util.List;

@Service
public class RecipeIngredientService {

    private final RecipeIngredientDAOImpl recipeIngredientDAO;

    @Autowired
    public RecipeIngredientService(RecipeIngredientDAOImpl recipeIngredientDAO) {
        this.recipeIngredientDAO = recipeIngredientDAO;
    }

    public RecipeIngredient createRecipeIngredient(RecipeIngredient recipeIngredient) {
        return recipeIngredientDAO.create(recipeIngredient);
    }

    public RecipeIngredient findById(Integer recipeIngredientId) {
        return recipeIngredientDAO.findById(recipeIngredientId);
    }

    public List<RecipeIngredient> findAll() {
        return recipeIngredientDAO.findAll();
    }

    public RecipeIngredient update(RecipeIngredient recipeIngredient) {
        return recipeIngredientDAO.update(recipeIngredient);
    }

    public RecipeIngredient delete(RecipeIngredient recipeIngredient) {
        return recipeIngredientDAO.delete(recipeIngredient);
    }

    public void clear() {
        recipeIngredientDAO.clear();
    }


}
