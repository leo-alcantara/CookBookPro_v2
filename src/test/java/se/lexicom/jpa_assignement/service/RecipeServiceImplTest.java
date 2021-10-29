package se.lexicom.jpa_assignement.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicom.jpa_assignement.DAO.IngredientDAO;
import se.lexicom.jpa_assignement.DAO.RecipeCategoryDAO;
import se.lexicom.jpa_assignement.DAO.RecipeDAO;
import se.lexicom.jpa_assignement.DAO.RecipeIngredientDAO;
import se.lexicom.jpa_assignement.entity.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeServiceImplTest {

    @Autowired
    IngredientDAO ingredientDAO;
    @Autowired
    RecipeIngredientDAO recipeIngredientDAO;
    @Autowired
    RecipeCategoryDAO recipeCategoryDAO;
    @Autowired
    RecipeDAO recipeDAO;

    Recipe vanillaCake = new Recipe();

    @BeforeEach
    void setUp() {
        //For   creating recipe

        //Define recipe name
        vanillaCake.setRecipeName("Vanilla Cake");
        // define ingredients
        Ingredient butter = new Ingredient("Butter");
        Ingredient milk = new Ingredient("Milk");
        //Ingredient createdButter = ingredientDAO.create(butter);
        //Ingredient createdMilk = ingredientDAO.create(milk);

        // define RecipeIngredient
        RecipeIngredient butterRecipeIngredients = new RecipeIngredient(butter, 200, Measurement.GRAM);
        RecipeIngredient milkRecipeIngredients = new RecipeIngredient(milk, 2, Measurement.LITER);
        //RecipeIngredient createdButterRecipeIngredients = recipeIngredientDAO.create(butterRecipeIngredients);
        //RecipeIngredient createdMilkRecipeIngredients = recipeIngredientDAO.create(milkRecipeIngredients);

        // assign ingredients to the recipeingredient list
        vanillaCake.addRecipeIngredient(butterRecipeIngredients);
        vanillaCake.addRecipeIngredient(milkRecipeIngredients);

        // define RecipeInstruction
        RecipeInstruction vanillaCakeInstruction = new RecipeInstruction("Do it!");
        vanillaCake.setInstructions(vanillaCakeInstruction);
        // define Categories
        RecipeCategory desert = new RecipeCategory("Deserts");
        //RecipeCategory createdDesert = recipeCategoryDAO.create(desert);

        // assign category to recipe
        Set<RecipeCategory> categories = new HashSet<>();
        categories.add(desert);
        vanillaCake.setCategories(categories);

    }

    @Test
    void createRecipe() {
        // save to DB
        recipeDAO.create(vanillaCake);
    }

    @Test
    void findById() {

        Recipe recipe = recipeDAO.create(vanillaCake);
        Recipe  foundVanillaCakeRecipe = recipeDAO.findById(recipe.getRecipeId());
        System.out.println(foundVanillaCakeRecipe.getIngredients());

    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void clear() {
    }

    @Test
    void findRecipeByNameContainsIgnoreCase() {
    }

    @Test
    void findRecipeByIngredientNameContainsIgnoreCase() {
    }

    @Test
    void findRecipeByCategoryContainsIgnoreCase() {
    }

    @Test
    void findRecipeSeveralCategories() {
    }
}