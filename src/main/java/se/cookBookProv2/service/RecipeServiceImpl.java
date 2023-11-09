package se.cookBookProv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.cookBookProv2.DAO.IngredientDAOImpl;
import se.cookBookProv2.DAO.RecipeCategoryDAOImpl;
import se.cookBookProv2.DAO.RecipeDAOImpl;
import se.cookBookProv2.DAO.RecipeIngredientDAOImpl;
import se.cookBookProv2.dto.RecipeDto;
import se.cookBookProv2.dto.RecipeIngredientFormDto;
import se.cookBookProv2.entity.*;
import se.cookBookProv2.exceptions.ExceptionManager;
import se.cookBookProv2.dto.RecipeFormDto;

import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeDAOImpl recipeDAO;
    private final ConversionService convert;
    private final RecipeCategoryDAOImpl recipeCategoryDAO;
    private final IngredientDAOImpl ingredientDAO;
    private final RecipeIngredientDAOImpl recipeIngredientDAO;

    @Autowired
    public RecipeServiceImpl(RecipeDAOImpl recipeDAO, ConversionService convert,
                             RecipeCategoryDAOImpl recipeCategoryDAO, IngredientDAOImpl ingredientDAO, RecipeIngredientDAOImpl recipeIngredientDAO) {
        this.recipeDAO = recipeDAO;
        this.convert = convert;
        this.recipeCategoryDAO = recipeCategoryDAO;
        this.ingredientDAO = ingredientDAO;
        this.recipeIngredientDAO = recipeIngredientDAO;
    }

    @Override
    @Transactional
    public RecipeDto createRecipe(RecipeDto recipeDto) {
        Recipe recipe = convert.toRecipe(recipeDto);
        if (!recipeDAO.findRecipeByNameContainsIgnoreCase(recipe.getRecipeName()).isEmpty()) throw new ExceptionManager("Recipe already exists");

        Set<RecipeCategory> categorySet = new HashSet<>();
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);
        for (RecipeCategory category : recipe.getCategories()) {
            RecipeCategory categoryByName = recipeCategoryDAO.findByName(category.getCategory());
            if (categoryByName == null) categoryByName = new RecipeCategory(category.getCategory(), recipeList);

            categorySet.add(categoryByName);
        }

        for (RecipeIngredient recipeIngredient : recipe.getIngredients()) {
            recipe.addRecipeIngredient(recipeIngredient);
        }

        //Need to check ingredients to try stop duplicates. Not sure if this is the correct way.
        List<RecipeIngredient> recipeIngredientList = recipe.getIngredients();
        for (RecipeIngredient ri : recipeIngredientList) {
            if(recipeIngredientDAO.findById(ri.getIngredient().getIngredientId()) == null) {
                Ingredient ingredient = new Ingredient(ri.getIngredient().getIngredientId(), ri.getIngredient().getIngredientName());
                ingredientDAO.create(ingredient);
            }
        }

        /*RecipeInstruction recipeInstruction = new RecipeInstruction(recipe.getInstructions().getRecipeInstructionId(), recipe.getInstructions().getRecipeInstructions());
        recipe.setInstructions(recipeInstruction);*/

        recipe.setCategories(categorySet);
        recipeDAO.create(recipe);
        return convert.toRecipeDto(recipe);
    }

    @Override
    @Transactional
    public RecipeDto findById(Integer recipeId) {
        Recipe foundRecipe = recipeDAO.findById(recipeId);
        System.out.println("foundRecipe = " + foundRecipe);
        RecipeDto dto = convert.toRecipeDto(foundRecipe);
        return dto;
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
    public RecipeDto update(RecipeDto recipeDto) {
        Recipe original = recipeDAO.update(convert.toRecipe(recipeDto));
        return convert.toRecipeDto(original);
    }

    @Override
    @Transactional
    public RecipeDto delete(Integer recipeId) {
        Recipe recipe = recipeDAO.findById(recipeId);
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
