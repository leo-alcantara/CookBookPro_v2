package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.DAO.RecipeDAOImpl;
import se.lexicom.jpa_assignement.dto.RecipeDto;
import se.lexicom.jpa_assignement.form.RecipeFormDto;
import se.lexicom.jpa_assignement.model.Recipe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeDAOImpl recipeDAO;
    private final ConversionService convert;

    @Autowired
    public RecipeServiceImpl(RecipeDAOImpl recipeDAO, ConversionService convert) {
        this.recipeDAO = recipeDAO;
        this.convert = convert;
    }

    @Override
    @Transactional
    public RecipeDto createRecipe(RecipeFormDto formDto) {
        Recipe saved = recipeDAO.create(convert.toRecipe(formDto));
        return convert.toRecipeDto(saved);
    }

    @Override
    @Transactional
    public RecipeDto findById(Integer recipeId) {
        Recipe foundRecipe = recipeDAO.findById(recipeId);
        return convert.toRecipeDto(foundRecipe);
    }

    @Override
    @Transactional
    public List<RecipeDto> findAll() {
        List<Recipe> recipeList = recipeDAO.findAll();
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        recipeList.forEach((r) -> recipeDtoList.add(convert.toRecipeDto(r)));
        return recipeDtoList;
    }

    @Override
    @Transactional
    public RecipeDto update(RecipeFormDto formDto) {
        Recipe original = recipeDAO.update(convert.toRecipe(formDto));
        return convert.toRecipeDto(original);
    }

    @Override
    @Transactional
    public RecipeDto delete(Recipe recipe) {
        recipeDAO.delete(recipe);
        return convert.toRecipeDto(recipe);
    }

    @Override
    @Transactional
    public void clear() {
        recipeDAO.clear();
    }

    @Override
    @Transactional
    public List<RecipeDto> findRecipeByNameContainsIgnoreCase(String recipeName) {
        List<Recipe> foundByNameList = recipeDAO.findRecipeByNameContainsIgnoreCase(recipeName);
        List<RecipeDto> foundByNameDto = new ArrayList<>();
        foundByNameList.forEach((r) -> foundByNameDto.add(convert.toRecipeDto(r)));
        return foundByNameDto;
    }

    @Override
    @Transactional
    public List<RecipeDto> findRecipeByIngredientNameContainsIgnoreCase(String ingredientName) {
        List<Recipe> foundByIngredientList = recipeDAO.findRecipeByIngredientNameContainsIgnoreCase(ingredientName);
        List<RecipeDto> foundByIngredientDto = new ArrayList<>();
        foundByIngredientList.forEach((r) -> foundByIngredientDto.add(convert.toRecipeDto(r)));
        return foundByIngredientDto;
    }

    @Override
    @Transactional
    public List<RecipeDto> findRecipeByCategoryContainsIgnoreCase(String categoryName) {
        List<Recipe> foundByCategoryList = recipeDAO.findRecipeByCategoryContainsIgnoreCase(categoryName);
        List<RecipeDto> foundByCategoryDto = new ArrayList<>();
        foundByCategoryList.forEach((r) -> foundByCategoryDto.add(convert.toRecipeDto(r)));
        return foundByCategoryDto;
    }

    @Override
    @Transactional
    public List<RecipeDto> findRecipeSeveralCategories(Collection<String> recipeCategories) {
        List<Recipe> foundBySeveralCategoryList = recipeDAO.findRecipeSeveralCategories(recipeCategories);
        List<RecipeDto> foundBySeveralCategoryDto = new ArrayList<>();
        foundBySeveralCategoryList.forEach((r) -> foundBySeveralCategoryDto.add(convert.toRecipeDto(r)));
        return foundBySeveralCategoryDto;
    }
}
