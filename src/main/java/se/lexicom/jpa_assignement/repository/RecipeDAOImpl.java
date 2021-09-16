package se.lexicom.jpa_assignement.repository;

import org.springframework.stereotype.Repository;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.model.Recipe;
import se.lexicom.jpa_assignement.model.RecipeCategory;
import se.lexicom.jpa_assignement.model.RecipeIngredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

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
            throw new ExceptionManager("There is no such ingredient called: " + ingredientName);
        }
        return entityManager.createQuery("SELECT r FROM Recipe r JOIN FETCH r.ingredients AS ri WHERE ri.ingredient.ingredientName = ?1", Recipe.class)
                .setParameter(1, ingredientName).getResultList();
    }

    @Override
    @Transactional
    public Collection<Recipe> findRecipeByCategory(String categoryName) throws ExceptionManager {
        if (categoryName == null) {
            throw new ExceptionManager("There is no such category called: " + categoryName);
        }
        return  entityManager.createQuery("SELECT r FROM Recipe r JOIN FETCH r.categories AS rc WHERE rc.category = ?1", Recipe.class)
                .setParameter(1, categoryName).getResultList();
    }

    //TALK TO SIMON
    @Override
    @Transactional
    public Collection<Recipe> findRecipeSeveralCategories(Collection<String> recipeCategory) {
        return entityManager.createQuery("SELECT r FROM Recipe r JOIN FETCH r.categories AS rc WHERE rc.category in (:recipeCategory)", Recipe.class)
                .setParameter("recipeCategory", recipeCategory).getResultList();
    }




}
