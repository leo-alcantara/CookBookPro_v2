package se.lexicom.jpa_assignement.DAO;

import org.springframework.stereotype.Repository;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.model.RecipeIngredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    public RecipeIngredient delete(RecipeIngredient recipeIngredient) throws ExceptionManager {
        if (recipeIngredient == null) {
            throw new ExceptionManager("Can not delete item: " + recipeIngredient);
        }
        entityManager.remove(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    public List<RecipeIngredient> findAll() {
        return entityManager.createQuery("SELECT r FROM RecipeIngredient r", RecipeIngredient.class).getResultList();
    }

    @Override
    public RecipeIngredient findById(String recipeIngredientId) throws ExceptionManager {
        if (recipeIngredientId == null) {
            throw new ExceptionManager("Can not find item: " + recipeIngredientId);
        }
        return entityManager.find(RecipeIngredient.class, recipeIngredientId);
    }

    @Override
    public RecipeIngredient update(RecipeIngredient recipeIngredient) throws ExceptionManager {
        if (recipeIngredient == null) {
            throw new ExceptionManager("Can not update item: " + recipeIngredient);
        }
        return entityManager.merge(recipeIngredient);
    }

    @Override
    public void clear() {
        entityManager.clear();
    }
}
