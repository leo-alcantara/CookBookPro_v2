package se.cookBookProv2.DAO;

import se.cookBookProv2.entity.RecipeCategory;

public interface RecipeCategoryDAO extends GenericCRUDMethods <RecipeCategory, Integer>{

    RecipeCategory findByName(String categoryName);

}
