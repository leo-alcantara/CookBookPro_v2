package se.lexicom.jpa_assignement.DAO;

import se.lexicom.jpa_assignement.model.Ingredient;

public interface IngredientDAO extends GenericCRUDMethods <Ingredient, Integer>{

    Ingredient findIngredientByNameContainsIgnoreCase(String ingredientName);
}
