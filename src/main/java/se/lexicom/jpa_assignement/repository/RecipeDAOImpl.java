package se.lexicom.jpa_assignement.repository;

import org.springframework.stereotype.Repository;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.model.Recipe;
import se.lexicom.jpa_assignement.model.RecipeCategory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository

public class RecipeDAOImpl implements RecipeDAO {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Recipe create(Recipe recipe) throws ExceptionManager {
        if (recipe == null) {
            throw new ExceptionManager("Can not save item: " + recipe);
        }
        entityManager.persist(recipe);
        return recipe;
    }

    @Override
    @Transactional
    public Recipe delete(Recipe recipe) {
        entityManager.remove(recipe);
        return recipe;
    }


    @Override
    @Transactional
    public Collection<Recipe> findAll() {
        Query query = entityManager.createQuery("SELECT r FROM Recipe r");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Recipe findById(Integer integer) {
        Recipe recipe = entityManager.find(Recipe.class, integer);
        return recipe;
    }

    @Override
    @Transactional
    public Recipe update(Recipe recipe) {
        return entityManager.merge(recipe);
    }

    @Override
    @Transactional
    public void clear() {
        entityManager.clear();

    }

    @Override
    @Transactional
    public Collection<Recipe> findRecipeByName(String recipeName) throws ExceptionManager {
        if (recipeName == null) {
            throw new ExceptionManager("Can not find item: " + recipeName);
        }
        Query query = entityManager.createQuery("SELECT r FROM Recipe r WHERE r.recipeName = ?1", Recipe.class)
                .setParameter(1, recipeName);
        return query.getResultList();
    }

    //TEST
    @Override
    @Transactional
    public Collection<Recipe> findRecipeByIngredientName(String ingredientName) throws ExceptionManager {
        if (ingredientName == null) {
            throw new ExceptionManager("Can not find item: " + ingredientName);
        }
        Query query = entityManager.createQuery("SELECT r.recipe FROM RecipeIngredient r WHERE r.ingredient.ingredientName = ?1", Recipe.class)
                .setParameter(1, ingredientName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Collection<Recipe> findRecipeByCategory(RecipeCategory category) throws ExceptionManager {
        if (category == null) {
            throw new ExceptionManager("Can not find item: " + category);
        }
        Query query = entityManager.createQuery("SELECT r FROM Recipe r WHERE r.categories = ?1", Recipe.class)
                .setParameter(1, category);

        return query.getResultList();
    }

    //TALK TO SIMON
    @Override
    @Transactional
    public Collection<Recipe> findRecipeSeveralCategories(RecipeCategory recipeCategory) {
       Query query = entityManager.createQuery("SELECT r, c FROM Recipe r, RecipeCategory c WHERE c.category in (?1)", Recipe.class);
        query.setParameter(1, recipeCategory);

        return query.getResultList();
    }
}
