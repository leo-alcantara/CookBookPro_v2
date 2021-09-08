package se.lexicom.jpa_assignement.repository;

import se.lexicom.jpa_assignement.model.Ingredient;

public interface IngredientDAO extends GenericCRUDMethods <Ingredient, Integer>{

    Ingredient findIngredientByName(String ingredientName);

    Ingredient findIngredientByNameContain(String ingredientName);
}
