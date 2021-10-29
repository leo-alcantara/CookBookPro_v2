package se.lexicom.jpa_assignement.DAO;

import se.lexicom.jpa_assignement.entity.RecipeCategory;

public interface RecipeCategoryDAO extends GenericCRUDMethods <RecipeCategory, Integer>{

    RecipeCategory findByName(String categoryName);

}
