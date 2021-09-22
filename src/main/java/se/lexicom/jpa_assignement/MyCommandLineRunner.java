package se.lexicom.jpa_assignement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.model.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {


        List<RecipeIngredient> ingredients = new ArrayList<>();
        List<RecipeCategory> categories = new ArrayList<>();
        List<Recipe> recipes = new ArrayList<>();

        RecipeIngredient recipeIngredient = new RecipeIngredient(new Ingredient("Salt"), 10, Measurement.GRAM, null);
        //entityManager.persist(recipeIngredient);

        RecipeCategory recipeCategory = new RecipeCategory("Vegan", recipes);
        //entityManager.persist(recipeCategory);

        RecipeInstruction instruction = new RecipeInstruction("ABC");
        //entityManager.persist(instruction);

        ingredients.add(recipeIngredient);
        categories.add(recipeCategory);

        Recipe recipe = new Recipe("Feijoada", ingredients, instruction, categories);
        entityManager.persist(recipe);

        System.out.println(recipe.toString());


    }
}
