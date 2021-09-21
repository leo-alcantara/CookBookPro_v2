package se.lexicom.jpa_assignement.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
@Transactional
class RecipeTest {

    @Autowired
    TestEntityManager testEntityManager;

    private Recipe recipe;
    private Recipe testRecipe;
    private Recipe testRecipe2;
    private Recipe testRecipe3;

    private List<RecipeIngredient> ingredientsList;
    private List<RecipeIngredient> ingredientsList2;
    private List<RecipeIngredient> ingredientsList3;

    private RecipeInstruction recipeInstruction;

    private List<RecipeCategory> recipeCategories;

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
        recipeCategories = new ArrayList<>();
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
        categoryNames = new ArrayList<>();
        categoryNames.add("BBQ");
        categoryNames.add("Vegan");
        categoryNames.add(ingredient3.getIngredientName());

        testRecipe = testEntityManager
                .persist(new Recipe("Feijoada", ingredientsList, recipeInstruction, recipeCategories));
        testRecipe2 = testEntityManager
                .persist(new Recipe("Onion Soup", ingredientsList2, recipeInstruction, recipeCategories));
        testRecipe3 = testEntityManager
                .persist(new Recipe("Rib Eye", ingredientsList3, recipeInstruction, recipeCategories));
    }

    @Test
    void addRecipeIngredient() {
        //Arrange
        assertFalse(testRecipe.getIngredients().contains(recipeIngredient2));
        //Act
        testRecipe.addRecipeIngredient(recipeIngredient2);
        testRecipe2.addRecipeIngredient(recipeIngredient3);
        testRecipe3.addRecipeIngredient(recipeIngredient);

        //Assert
        assertTrue(testRecipe.getIngredients().contains(recipeIngredient2));
        assertTrue(testRecipe2.getIngredients().contains(recipeIngredient3));
        assertTrue(testRecipe3.getIngredients().contains(recipeIngredient));
    }

    @Test
    void removeRecipeIngredients() {
        //Arrange
        assertTrue(testRecipe.getIngredients().contains(recipeIngredient));
        //Act
        testRecipe.removeRecipeIngredients(recipeIngredient);

        //Assert
        assertFalse(testRecipe.getIngredients().contains(recipeIngredient));
    }

    @Test
    void addRecipeCategory() {
        //Arrange
        assertFalse(testRecipe.getCategories().contains(recipeCategory3));

        //Act
        testRecipe.addRecipeCategory(recipeCategory3);

        //Assert
        assertTrue(testRecipe.getCategories().contains(recipeCategory3));

    }

    @Test
    void removeRecipeCategory() {
        //Arrange
        assertTrue(testRecipe.getCategories().contains(recipeCategory2));

        //Act
        testRecipe.removeRecipeCategory(recipeCategory2);

        //Assert
        assertFalse(testRecipe.getCategories().contains(recipeCategory2));
    }
}