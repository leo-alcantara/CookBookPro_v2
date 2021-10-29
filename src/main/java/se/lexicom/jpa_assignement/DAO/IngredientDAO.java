package se.lexicom.jpa_assignement.DAO;

import se.lexicom.jpa_assignement.entity.Ingredient;

public interface IngredientDAO extends GenericCRUDMethods <Ingredient, Integer>{

    Ingredient findIngredientByNameContainsIgnoreCase(String ingredientName);
}
