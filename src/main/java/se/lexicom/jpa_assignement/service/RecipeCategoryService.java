package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicom.jpa_assignement.DAO.RecipeCategoryDAOImpl;
import se.lexicom.jpa_assignement.model.RecipeCategory;

import java.util.List;

@Service
public class RecipeCategoryService {

    private final RecipeCategoryDAOImpl recipeCategoryDAO;

    @Autowired
    public RecipeCategoryService(RecipeCategoryDAOImpl recipeCategoryDAO) {
        this.recipeCategoryDAO = recipeCategoryDAO;
    }

    public RecipeCategory createRecipeCategory(RecipeCategory recipeCategory) {
        return recipeCategoryDAO.create(recipeCategory);
    }

    public RecipeCategory findById(Integer recipeCategoryId) {
        return recipeCategoryDAO.findById(recipeCategoryId);
    }

    public List<RecipeCategory> findAll() {
        return recipeCategoryDAO.findAll();
    }

    public RecipeCategory update(RecipeCategory recipeCategory) {
        return recipeCategoryDAO.update(recipeCategory);
    }

    public RecipeCategory delete(RecipeCategory recipeCategory) {
        return recipeCategoryDAO.delete(recipeCategory);
    }

    public void clear() {
        recipeCategoryDAO.clear();
    }




}
