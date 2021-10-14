package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicom.jpa_assignement.DAO.IngredientDAOImpl;
import se.lexicom.jpa_assignement.model.Ingredient;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientDAOImpl ingredientDAO;

    @Autowired
    public IngredientService(IngredientDAOImpl ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    public Ingredient createIngredient(Ingredient ingredient){
        return ingredientDAO.create(ingredient);
    }

    public Ingredient findById(Integer ingredientId){
        return ingredientDAO.findById(ingredientId);
    }

    public List<Ingredient> findAll(){
       return ingredientDAO.findAll();
    }

    public Ingredient update(Ingredient ingredient){
        return ingredientDAO.update(ingredient);
    }

    public Ingredient delete(Ingredient ingredient){
       return ingredientDAO.delete(ingredient);
    }

    public void clear(){
        ingredientDAO.clear();
    }

    public Ingredient findIngredientByNameContainsIgnoreCase(String ingredientName){
        return ingredientDAO.findIngredientByNameContainsIgnoreCase(ingredientName);
    }




}
