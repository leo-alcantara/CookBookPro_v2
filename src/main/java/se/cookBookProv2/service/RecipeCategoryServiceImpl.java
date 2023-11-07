package se.cookBookProv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.cookBookProv2.DAO.RecipeCategoryDAOImpl;
import se.cookBookProv2.dto.RecipeCategoryDto;
import se.cookBookProv2.dto.RecipeCategoryFormDto;
import se.cookBookProv2.entity.RecipeCategory;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeCategoryServiceImpl implements RecipeCategoryService {

    private final RecipeCategoryDAOImpl recipeCategoryDAO;
    private final ConversionService convert;

    @Autowired
    public RecipeCategoryServiceImpl(RecipeCategoryDAOImpl recipeCategoryDAO, ConversionService convert) {
        this.recipeCategoryDAO = recipeCategoryDAO;
        this.convert = convert;
    }

    @Override
    @Transactional
    public RecipeCategoryDto createRecipeCategory(RecipeCategoryFormDto form) {
        RecipeCategory saved = recipeCategoryDAO.create(convert.toRecipeCategory(form));
        return convert.toRecipeCategoryDto(saved);
    }

    @Override
    @Transactional
    public RecipeCategoryDto findById(Integer recipeCategoryId) {
        RecipeCategory foundRecipeCategory = recipeCategoryDAO.findById(recipeCategoryId);
        return convert.toRecipeCategoryDto(foundRecipeCategory);
    }

    @Override
    @Transactional
    public List<RecipeCategoryDto> findAll() {
        List<RecipeCategory> recipeCategoryList = recipeCategoryDAO.findAll();
        List<RecipeCategoryDto> recipeCategoryDtoList = new ArrayList<>();
        recipeCategoryList.forEach((rc) -> recipeCategoryDtoList.add(convert.toRecipeCategoryDto(rc)));
        return recipeCategoryDtoList;
    }

    @Override
    @Transactional
    public RecipeCategoryDto update(RecipeCategoryFormDto formDto) {
        RecipeCategory original = recipeCategoryDAO.update(convert.toRecipeCategory(formDto));
        return convert.toRecipeCategoryDto(original);
    }

    @Override
    @Transactional
    public RecipeCategoryDto delete(RecipeCategory recipeCategory) {
        recipeCategoryDAO.delete(recipeCategory);
        return convert.toRecipeCategoryDto(recipeCategory);
    }

    @Override
    @Transactional
    public void clear() {
        recipeCategoryDAO.clear();
    }
}
