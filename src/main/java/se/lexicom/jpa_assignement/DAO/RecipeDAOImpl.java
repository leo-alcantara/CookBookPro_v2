package se.lexicom.jpa_assignement.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.entity.Recipe;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public Recipe delete(Recipe recipe) throws ExceptionManager {
        if (recipe == null) {
            throw new ExceptionManager(recipe + " recipe does not exist in the database.");
        }
        entityManager.remove(recipe);
        return recipe;
    }

    @Override
    @Transactional
    public List<Recipe> findAll() {
        return entityManager.createQuery("SELECT r FROM Recipe r", Recipe.class).getResultList();
    }

    @Override
    @Transactional
    public Recipe findById(Integer integer) {
        return entityManager.find(Recipe.class, integer);
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
    public List<Recipe> findRecipeByNameContainsIgnoreCase(String recipeName) throws ExceptionManager {
        if (recipeName == null) {
            throw new ExceptionManager("Can not find item: " + recipeName);
        }
        return entityManager.createQuery("SELECT r FROM Recipe r WHERE UPPER(r.recipeName ) LIKE UPPER(CONCAT('%', ?1 , '%'))", Recipe.class)
                .setParameter(1, recipeName).getResultList();
    }

    @Override
    @Transactional
    public List<Recipe> findRecipeByIngredientNameContainsIgnoreCase(String ingredientName) throws ExceptionManager {
        if (ingredientName == null) {
            throw new ExceptionManager("There is no such ingredient called: " + ingredientName);
        }
        return entityManager.createQuery("SELECT r FROM Recipe r JOIN FETCH r.ingredients AS ri WHERE UPPER(ri.ingredient.ingredientName) LIKE UPPER(CONCAT('%', ?1, '%'))", Recipe.class)
                .setParameter(1, ingredientName).getResultList();
    }

    @Override
    @Transactional
    public List<Recipe> findRecipeByCategoryContainsIgnoreCase(String categoryName) throws ExceptionManager {
        if (categoryName == null) {
            throw new ExceptionManager("There is no such category called: " + categoryName);
        }
        return entityManager.createQuery("SELECT r FROM Recipe r JOIN FETCH r.categories AS rc WHERE UPPER(rc.category) LIKE UPPER(CONCAT('%', ?1 , '%'))", Recipe.class)
                .setParameter(1, categoryName).getResultList();
    }

    @Override
    @Transactional
    public List<Recipe> findRecipeSeveralCategories(Collection<String> recipeCategories) throws ExceptionManager {
        if (recipeCategories == null) {
            throw new ExceptionManager("There is no such category called: " + recipeCategories);
        }
        return entityManager.createQuery("SELECT r FROM Recipe r JOIN FETCH r.categories AS rc WHERE rc.category in (:recipeCategory)", Recipe.class)
                .setParameter("recipeCategory", recipeCategories).getResultList();
    }


}
