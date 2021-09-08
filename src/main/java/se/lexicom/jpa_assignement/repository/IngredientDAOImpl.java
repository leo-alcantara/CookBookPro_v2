package se.lexicom.jpa_assignement.repository;

import se.lexicom.jpa_assignement.model.Ingredient;

import java.util.Collection;

public class IngredientDAOImpl implements IngredientDAO {

    @Override
    public Ingredient create(Ingredient ingredient) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public Collection<Ingredient> findAll() {
        return null;
    }

    @Override
    public Ingredient findById(Integer integer) {
        return null;
    }

    @Override
    public boolean update(Ingredient ingredient) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Ingredient findIngredientByName(String ingredientName) {
        return null;
    }

    @Override
    public Ingredient findIngredientByNameContain(String ingredientName) {
        return null;
    }
}
