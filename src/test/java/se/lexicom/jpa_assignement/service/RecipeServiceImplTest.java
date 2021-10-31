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
    @Autowired
    RecipeServiceImpl recipeService;

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
    void test_createRecipe_successful() {
        // Arrange
        Recipe testRecipe;

        // Act
        testRecipe = recipeDAO.create(vanillaCake);

        // Assert
        assertNotNull(testRecipe);
        assertNotNull(testRecipe.getRecipeId());
        assertEquals(testRecipe.getRecipeName(), vanillaCake.getRecipeName());

    }

    @Test
    void test_findById_successful() {
        // Arrange
        recipeDAO.create(vanillaCake);
        Recipe testRecipe;
        int id = 0;

        // Act
        testRecipe = recipeDAO.findById(vanillaCake.getRecipeId());

        // Assert
        assertNotNull(testRecipe);
        assertNotNull(testRecipe.getRecipeId());
        assertEquals(testRecipe.getRecipeId(), vanillaCake.getRecipeId());
        assertNotEquals(id, testRecipe.getRecipeId());
    }

    @Test
    void test_findAll_successful() {
        //Arrange
        recipeDAO.create(vanillaCake);
        Collection<Recipe> testRecipes;

        //Act
        testRecipes = recipeDAO.findAll();

        //Assert
        assertNotEquals(0, testRecipes.size());
        assertNotNull(testRecipes);
    }


    //Not sure how to test this method
    @Test
    void update() {
        //Arrange
        recipeDAO.create(vanillaCake);
        Recipe testRecipe = recipeDAO.findById(vanillaCake.getRecipeId());
        //Act
        testRecipe.setRecipeName("Strawberry Cake");
        recipeDAO.update(testRecipe);
        //Assert
        assertNotEquals(vanillaCake.getRecipeName(), testRecipe.getRecipeName());
    }

    @Test
    void delete() {
        //Arrange
        recipeDAO.create(vanillaCake);
        Recipe testRecipe = recipeDAO.findById(vanillaCake.getRecipeId());
        //Act
        recipeDAO.delete(testRecipe);
        Recipe newTestRecipe = recipeDAO.findById(testRecipe.getRecipeId());
        //Assert
        assertNull(newTestRecipe);

    }

    @Test
    void clear() {
        //Arrange
        //Act
        //Assert
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