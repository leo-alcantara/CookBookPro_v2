package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicom.jpa_assignement.DAO.IngredientDAOImpl;
import se.lexicom.jpa_assignement.model.Ingredient;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientDAOImpl ingredientDAO;

    @Autowired
    public IngredientServiceImpl(IngredientDAOImpl ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientDAO.create(ingredient);
    }

    @Override
    public Ingredient findById(Integer ingredientId) {
        return ingredientDAO.findById(ingredientId);
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientDAO.findAll();
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        return ingredientDAO.update(ingredient);
    }

    @Override
    public Ingredient delete(Ingredient ingredient) {
        return ingredientDAO.delete(ingredient);
    }

    @Override
    public void clear() {
        ingredientDAO.clear();
    }

    @Override
    public Ingredient findIngredientByNameContainsIgnoreCase(String ingredientName){
        return ingredientDAO.findIngredientByNameContainsIgnoreCase(ingredientName);
    }




}
