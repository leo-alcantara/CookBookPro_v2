package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.DAO.IngredientDAOImpl;
import se.lexicom.jpa_assignement.DAO.RecipeCategoryDAOImpl;
import se.lexicom.jpa_assignement.DAO.RecipeDAOImpl;
import se.lexicom.jpa_assignement.dto.RecipeDto;
import se.lexicom.jpa_assignement.dto.RecipeIngredientFormDto;
import se.lexicom.jpa_assignement.entity.*;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.dto.RecipeFormDto;

import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeDAOImpl recipeDAO;
    private final ConversionService convert;
    private final RecipeCategoryDAOImpl recipeCategoryDAO;
    private final IngredientDAOImpl ingredientDAO;

    @Autowired
    public RecipeServiceImpl(RecipeDAOImpl recipeDAO, ConversionService convert,
                             RecipeCategoryDAOImpl recipeCategoryDAO, IngredientDAOImpl ingredientDAO) {
        this.recipeDAO = recipeDAO;
        this.convert = convert;
        this.recipeCategoryDAO = recipeCategoryDAO;
        this.ingredientDAO = ingredientDAO;
    }

    @Override
    @Transactional
    public RecipeDto createRecipe(RecipeFormDto formDto) {
        Recipe recipe = convert.toRecipe(formDto);
        if (!recipeDAO.findRecipeByNameContainsIgnoreCase(recipe.getRecipeName()).isEmpty()) {
            throw new ExceptionManager("Recipe already exists");
        }
        Set<RecipeCategory> categorySet = new HashSet<>();
        for (String categoryName : formDto.getCategories()) {
            RecipeCategory category = recipeCategoryDAO.findByName(categoryName);
            if (Objects.isNull(category)) {
                category = new RecipeCategory(categoryName, new ArrayList<>());
            }
            categorySet.add(category);
        }

        RecipeIngredient recipeIngredient = new RecipeIngredient();
        for (RecipeIngredientFormDto recipeIngredientFormDto : formDto.getIngredients()) {
            recipeIngredient = convert.toRecipeIngredient(recipeIngredientFormDto);
            recipe.addRecipeIngredient(recipeIngredient);
        }

        //Need to check ingredients to try stop duplicates. Not sure this is the correct way.
        Ingredient ingredient = ingredientDAO.findIngredientByNameContainsIgnoreCase(recipeIngredient.getIngredient().getIngredientName());
        if (Objects.isNull(ingredient)) {
            ingredient = new Ingredient(recipeIngredient.getIngredient().getIngredientId(), recipeIngredient.getIngredient().getIngredientName());
            recipeIngredient.setIngredient(ingredient);
        }
        recipeIngredient.setIngredient(ingredient);


        RecipeInstruction recipeInstruction = new RecipeInstruction(recipe.getInstructions().getRecipeInstructionId(), formDto.getInstructions());
        recipe.setInstructions(recipeInstruction);

        recipe.setCategories(categorySet);
        Recipe createdRecipe = recipeDAO.create(recipe);
        RecipeDto convertedRecipe = convert.toRecipeDto(createdRecipe);
        System.out.println("createdRecipe.getIngredients() = " + createdRecipe.getIngredients());
        System.out.println("convertedRecipe.getIngredients() = " + convertedRecipe.getIngredients());
        return convertedRecipe;
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
    public RecipeDto update(RecipeFormDto formDto) {
        Recipe original = recipeDAO.update(convert.toRecipe(formDto));
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
