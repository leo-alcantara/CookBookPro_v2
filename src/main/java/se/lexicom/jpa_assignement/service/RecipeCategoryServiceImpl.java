package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicom.jpa_assignement.DAO.RecipeCategoryDAOImpl;
import se.lexicom.jpa_assignement.model.RecipeCategory;

import java.util.List;

@Service
public class RecipeCategoryServiceImpl implements RecipeCategoryService {

    private final RecipeCategoryDAOImpl recipeCategoryDAO;

    @Autowired
    public RecipeCategoryServiceImpl(RecipeCategoryDAOImpl recipeCategoryDAO) {
        this.recipeCategoryDAO = recipeCategoryDAO;
    }

    @Override
    public RecipeCategory createRecipeCategory(RecipeCategory recipeCategory) {
        return recipeCategoryDAO.create(recipeCategory);
    }

    @Override
    public RecipeCategory findById(Integer recipeCategoryId) {
        return recipeCategoryDAO.findById(recipeCategoryId);
    }

    @Override
    public List<RecipeCategory> findAll() {
        return recipeCategoryDAO.findAll();
    }

    @Override
    public RecipeCategory update(RecipeCategory recipeCategory) {
        return recipeCategoryDAO.update(recipeCategory);
    }

    @Override
    public RecipeCategory delete(RecipeCategory recipeCategory) {
        return recipeCategoryDAO.delete(recipeCategory);
    }

    @Override
    public void clear() {
        recipeCategoryDAO.clear();
    }




}
