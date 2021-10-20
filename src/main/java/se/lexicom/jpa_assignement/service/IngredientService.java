package se.lexicom.jpa_assignement.service;

import se.lexicom.jpa_assignement.model.Ingredient;

import java.util.List;

public interface IngredientService {
    Ingredient createIngredient(Ingredient ingredient);

    Ingredient findById(Integer ingredientId);

    List<Ingredient> findAll();

    Ingredient update(Ingredient ingredient);

    Ingredient delete(Ingredient ingredient);

    void clear();

    Ingredient findIngredientByNameContainsIgnoreCase(String ingredientName);
}
