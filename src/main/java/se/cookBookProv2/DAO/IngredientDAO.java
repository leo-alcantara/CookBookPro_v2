package se.cookBookProv2.DAO;

import se.cookBookProv2.entity.Ingredient;

public interface IngredientDAO extends GenericCRUDMethods <Ingredient, Integer>{

    Ingredient findIngredientByNameContainsIgnoreCase(String ingredientName);
}
