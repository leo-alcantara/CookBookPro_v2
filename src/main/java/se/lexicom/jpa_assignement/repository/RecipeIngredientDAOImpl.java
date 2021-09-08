package se.lexicom.jpa_assignement.repository;

import org.springframework.stereotype.Repository;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.model.RecipeIngredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class RecipeIngredientDAOImpl implements RecipeIngredientDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public RecipeIngredient create(RecipeIngredient recipeIngredient) throws ExceptionManager {
        if (recipeIngredient == null) {
            throw new ExceptionManager("Can not persist item: " + recipeIngredient);
        }
        entityManager.persist(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    public RecipeIngredient delete(RecipeIngredient recipeIngredient) {
        entityManager.remove(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    public Collection<RecipeIngredient> findAll() {
        Query query = entityManager.createQuery("SELECT r FROM RecipeIngredient r");
        return query.getResultList();
    }

    @Override
    public RecipeIngredient findById(Integer integer) {
        RecipeIngredient recipeIngredient = entityManager.find(RecipeIngredient.class, integer);
        return recipeIngredient;
    }

    @Override
    public RecipeIngredient update(RecipeIngredient recipeIngredient) {
        return entityManager.merge(recipeIngredient);
    }

    @Override
    public void clear() {
        entityManager.clear();
    }
}
