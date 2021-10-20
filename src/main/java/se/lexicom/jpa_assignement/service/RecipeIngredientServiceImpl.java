package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicom.jpa_assignement.DAO.RecipeIngredientDAOImpl;
import se.lexicom.jpa_assignement.model.RecipeIngredient;

import java.util.List;

@Service
public class RecipeIngredientServiceImpl implements RecipeIngredientService {

    private final RecipeIngredientDAOImpl recipeIngredientDAO;

    @Autowired
    public RecipeIngredientServiceImpl(RecipeIngredientDAOImpl recipeIngredientDAO) {
        this.recipeIngredientDAO = recipeIngredientDAO;
    }

    @Override
    public RecipeIngredient createRecipeIngredient(RecipeIngredient recipeIngredient) {
        return recipeIngredientDAO.create(recipeIngredient);
    }

    @Override
    public RecipeIngredient findById(Integer recipeIngredientId) {
        return recipeIngredientDAO.findById(recipeIngredientId);
    }

    @Override
    public List<RecipeIngredient> findAll() {
        return recipeIngredientDAO.findAll();
    }

    @Override
    public RecipeIngredient update(RecipeIngredient recipeIngredient) {
        return recipeIngredientDAO.update(recipeIngredient);
    }

    @Override
    public RecipeIngredient delete(RecipeIngredient recipeIngredient) {
        return recipeIngredientDAO.delete(recipeIngredient);
    }

    @Override
    public void clear() {
        recipeIngredientDAO.clear();
    }


}
