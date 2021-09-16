package se.lexicom.jpa_assignement.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.model.*;

import javax.transaction.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
@Transactional
class RecipeDAOImplTest {

    @Autowired
    private RecipeDAO recipeDAO;

    @Autowired
    TestEntityManager testEntityManager;

    private Recipe testRecipe;
    private int testId;

    private Collection<RecipeIngredient> ingredientsList;
    private RecipeInstruction recipeInstruction;
    private Collection<RecipeCategory> recipeCategories;
    private Ingredient ingredient;
    private Collection<Recipe> recipes;
    private RecipeIngredient recipeIngredient;
    private RecipeCategory recipeCategory;
    private RecipeCategory recipeCategory2;
    private Collection<String> categoryNames;

    @BeforeEach
    void setUp() {
        ingredientsList = new HashSet<>();
        recipeCategories = new HashSet<>();
        ingredient = new Ingredient("Salt");
        recipes = new HashSet<>();
        recipeIngredient = new RecipeIngredient(ingredient, 10, Measurement.GRAM, testRecipe);
        recipeCategory = new RecipeCategory("BBQ", recipes);
        recipeCategory2 = new RecipeCategory("Meat", recipes);
        ingredientsList.add(recipeIngredient);
        recipeCategories.add(recipeCategory);
        recipeCategories.add(recipeCategory2);
        categoryNames = new HashSet<>();
        categoryNames.add("BBQ");
        categoryNames.add("Vegan");

        testRecipe = testEntityManager.persist(new Recipe("Feijoada", ingredientsList, recipeInstruction, recipeCategories));
        testId = testRecipe.getRecipeId();
    }

    @Test
    void test_findRecipeByName_successful() {
        //Arrange
        Collection<Recipe> foundRecipes = null;
        //Act
        foundRecipes = recipeDAO.findRecipeByName("Feijoada");
        //Assert
        assertTrue(foundRecipes.contains(testRecipe));
    }

    //TALK TO SIMON WHAT TO ASSERT TO GET THE EXCEPTION THROWN
    @Test
    void test_findRecipeByName_throw_exception() {
        //Arrange
        String recipeName = null;
        //Act
        //Assert
        assertThrows(ExceptionManager.class, ()->recipeDAO.findRecipeByName(recipeName));
    }

    @Test
    void test_findRecipeByIngredientName_successful() {
        //Arrange
        Collection<Recipe> foundRecipes = null;
        int size = 1;
        //Act
        foundRecipes = recipeDAO.findRecipeByIngredientName("Salt");

        //Assert
        assertNotNull(foundRecipes);
        //assertEquals(size, foundRecipes.size());
    }

    @Test
    void test_findRecipeByCategory_successful() {
        //Arrange
        Collection<Recipe> foundRecipes = null;

        //Act
       foundRecipes = recipeDAO.findRecipeByCategory(recipeCategory.getCategory());

        //Assert
        assertEquals(1, foundRecipes.size());

    }

    @Test
    void test_findRecipeSeveralCategories_successful() {
        //Arrange
        Collection<Recipe> foundRecipes = null;

        //Act
        foundRecipes = recipeDAO.findRecipeSeveralCategories(categoryNames);

        //Assert
        assertNotNull(foundRecipes);
        assertEquals(1, foundRecipes.size());
    }
}