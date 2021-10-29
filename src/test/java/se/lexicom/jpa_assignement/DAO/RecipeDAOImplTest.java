package se.lexicom.jpa_assignement.DAO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.entity.*;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Recipe testRecipe2;
    private Recipe testRecipe3;

    private List<RecipeIngredient> ingredientsList;
    private List<RecipeIngredient> ingredientsList2;
    private List<RecipeIngredient> ingredientsList3;

    private RecipeInstruction recipeInstruction;

    private Set<RecipeCategory> recipeCategories;

    private Ingredient ingredient;
    private Ingredient ingredient2;
    private Ingredient ingredient3;

    private List<Recipe> recipes;

    private RecipeIngredient recipeIngredient;
    private RecipeIngredient recipeIngredient2;
    private RecipeIngredient recipeIngredient3;

    private RecipeCategory recipeCategory;
    private RecipeCategory recipeCategory2;
    private RecipeCategory recipeCategory3;

    private List<String> categoryNames;

    @BeforeEach
    void setUp() {
        ingredientsList = new ArrayList<>();
        ingredientsList2 = new ArrayList<>();
        ingredientsList3 = new ArrayList<>();
        recipeCategories = new HashSet<>();
        ingredient = new Ingredient("Salt");
        ingredient2 = new Ingredient("Onion");
        ingredient3 = new Ingredient("Garlic");
        recipes = new ArrayList<>();
        recipeIngredient = new RecipeIngredient(ingredient, 10, Measurement.GRAM, testRecipe);
        recipeIngredient2 = new RecipeIngredient(ingredient2, 10, Measurement.KILO, testRecipe2);
        recipeIngredient3 = new RecipeIngredient(ingredient3, 20, Measurement.GRAM, testRecipe3);
        recipeCategory = new RecipeCategory("BBQ", recipes);
        recipeCategory2 = new RecipeCategory("Meat", recipes);
        recipeCategory3 = new RecipeCategory("Soups", recipes);
        ingredientsList.add(recipeIngredient);
        ingredientsList2.add(recipeIngredient2);
        ingredientsList3.add(recipeIngredient3);
        recipeCategories.add(recipeCategory);
        recipeCategories.add(recipeCategory2);
        recipeCategories.add(recipeCategory3);
        categoryNames = new ArrayList<>();
        categoryNames.add("BBQ");
        categoryNames.add("Vegan");
        categoryNames.add(ingredient3.getIngredientName());

        testRecipe = testEntityManager.persist(new Recipe("Feijoada", ingredientsList, recipeInstruction, recipeCategories));
        testRecipe2 = testEntityManager.persist(new Recipe("Onion Soup", ingredientsList2, recipeInstruction, recipeCategories));
        testRecipe3 = testEntityManager.persist(new Recipe("Rib Eye", ingredientsList3, recipeInstruction, recipeCategories));

    }

    @Test
    void test_findRecipeByName_successful() {
        //Arrange
        List<Recipe> foundRecipes = null;
        List<Recipe> foundRecipes2 = null;
        testRecipe.setCategories(recipeCategories);
        //Act
        foundRecipes = recipeDAO.findRecipeByNameContainsIgnoreCase("Feijoada");
        foundRecipes2 = recipeDAO.findRecipeByNameContainsIgnoreCase(testRecipe2.getRecipeName());
        //Assert
        assertTrue(foundRecipes.contains(testRecipe));
        assertNotNull(foundRecipes);
        assertNotNull(foundRecipes2);
        assertTrue(foundRecipes2.contains(testRecipe2));
    }

    @Test
    void test_findRecipeByName_throw_exception() {
        //Arrange
        String recipeName = null;
        //Act
        //Assert
        assertThrows(ExceptionManager.class, ()->recipeDAO.findRecipeByNameContainsIgnoreCase(recipeName));
    }

    @Test
    void test_findRecipeByIngredientName_successful() {
        //Arrange
        List<Recipe> foundRecipes = null;
        int size = 1;
        testRecipe.addRecipeIngredient(recipeIngredient);
        //Act
        foundRecipes = recipeDAO.findRecipeByIngredientNameContainsIgnoreCase(recipeIngredient.getIngredient().getIngredientName());

        //Assert
        assertNotNull(foundRecipes);
        assertEquals(size, foundRecipes.size());
        assertTrue(foundRecipes.contains(testRecipe));
    }

    @Test
    void test_findRecipeByIngredientName_unsuccessful() {
        //Arrange
        List<Recipe> foundRecipes=null;
        int size = 0;

        //Act
        foundRecipes = recipeDAO.findRecipeByIngredientNameContainsIgnoreCase("Bay Leaf");

        //Assert
        //assertNull(foundRecipes);
        assertEquals(size, foundRecipes.size());
        assertTrue(foundRecipes.isEmpty());

    }

    @Test
    void test_findRecipeByIngredientName_throw_exception(){
        //Arrange
        String ingredientName = null;
        //Act
        //Assert
        assertThrows(ExceptionManager.class, ()->recipeDAO.findRecipeByIngredientNameContainsIgnoreCase(ingredientName));
    }

    @Test
    void test_findRecipeByCategory_successful() {
        //Arrange
        List<Recipe> foundRecipes = null;

        //Act
       foundRecipes = recipeDAO.findRecipeByCategoryContainsIgnoreCase(recipeCategory.getCategory());

        //Assert
        assertNotNull(foundRecipes);
        assertEquals(2, foundRecipes.size());
    }

    //Why list is not null anymore?
    @Test
    void test_findRecipeByCategory_unsuccessful() {
        //Arrange
        List<Recipe> foundRecipes = null;
        int size = 0;
        //Act
        foundRecipes = recipeDAO.findRecipeByCategoryContainsIgnoreCase("Breads");

        //Assert
        //assertNotNull(foundRecipes);
        assertEquals(size, foundRecipes.size());
        assertTrue(foundRecipes.isEmpty());
    }

    @Test
    void test_findRecipeByCategory_throw_exception(){
        //Arrange
        String category = null;
        //Act
        //Assert
        assertThrows(ExceptionManager.class, ()->recipeDAO.findRecipeByCategoryContainsIgnoreCase(category));
    }

    @Test
    void test_findRecipeSeveralCategories_successful() {
        //Arrange
        List<Recipe> foundRecipes = null;

        //Act
        foundRecipes = recipeDAO.findRecipeSeveralCategories(categoryNames);

        //Assert
        assertNotNull(foundRecipes);
        assertEquals(2, foundRecipes.size());
    }

    //Why list is not null anymore?
    @Test
    void test_findRecipeSeveralCategories_unsuccessful() {
        //Arrange
        List<Recipe> foundRecipes = null;
        List<String> names = new ArrayList<>();
        String halal = "Halal";
        String kosher = "Kosher";
        names.add(halal);
        names.add(kosher);
        int size = 0;

        //Act
        foundRecipes = recipeDAO.findRecipeSeveralCategories(names);

        //Assert
        assertNotNull(foundRecipes);
        assertEquals(size, foundRecipes.size());
        assertFalse(foundRecipes.contains(names));
    }

    @Test
    void test_findRecipeSeveralCategories_throw_exception(){
        //Arrange
        List<String> categoriesNames = null;
        //Act
        //Assert
        assertThrows(ExceptionManager.class, ()->recipeDAO.findRecipeSeveralCategories(categoriesNames));
    }
}