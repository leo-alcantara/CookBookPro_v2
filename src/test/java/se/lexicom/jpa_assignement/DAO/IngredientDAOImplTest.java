package se.lexicom.jpa_assignement.DAO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicom.jpa_assignement.entity.Ingredient;

import javax.transaction.Transactional;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
@Transactional
class IngredientDAOImplTest {

    @Autowired
    private IngredientDAO ingredientDAO;

    @Autowired
    TestEntityManager testEntityManager;

    private Ingredient testIngredient;
    private int testId;

    @BeforeEach
    void setUp() {
        testIngredient = testEntityManager.persist(new Ingredient("Salt"));
        testId = testIngredient.getIngredientId();
    }


    @Test
    void test_findIngredientByName_successful() {
        //Arrange
        Collection<Ingredient> found = new HashSet<>();
        Ingredient ingredientFound = null;

        //Act
        found.add(ingredientFound = ingredientDAO.findIngredientByNameContainsIgnoreCase(testIngredient.getIngredientName()));

        //Assert
        assertFalse(found.isEmpty());
        assertEquals("Salt", ingredientFound.getIngredientName());
    }

    @Test
    void test_findIngredientByNameContain_successful() {
        //Arrange
        Ingredient ingredientFound = null;

        //Act
        ingredientFound = ingredientDAO.findIngredientByNameContainsIgnoreCase("sa");
        //Assert
        assertEquals("Salt", ingredientFound.getIngredientName());

    }
}