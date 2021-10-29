package se.lexicom.jpa_assignement.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class RecipeTest {

    @Autowired
    TestEntityManager testEntityManager;


    private Recipe testRecipe;


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

        testRecipe = new Recipe("Feijoada", ingredientsList, recipeInstruction, recipeCategories);

    }

    @Test
    void addRecipeIngredient() {
        //Arrange
        //Act
        //Assert
        assertTrue(recipeIngredient.getRecipe().getRecipeName().equals("Feijoada"));

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