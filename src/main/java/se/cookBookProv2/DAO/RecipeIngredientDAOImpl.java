package se.cookBookProv2.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.cookBookProv2.exceptions.ExceptionManager;
import se.cookBookProv2.entity.RecipeIngredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RecipeIngredientDAOImpl implements RecipeIngredientDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public RecipeIngredient create(RecipeIngredient recipeIngredient) throws ExceptionManager {
        if (recipeIngredient == null) throw new ExceptionManager("Can not persist recipeIngredient: " + recipeIngredient);

        entityManager.persist(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    @Transactional
    public RecipeIngredient delete(RecipeIngredient recipeIngredient) throws ExceptionManager {
        if (recipeIngredient == null) throw new ExceptionManager("Can not delete recipeIngredient: " + recipeIngredient);

        entityManager.remove(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    @Transactional
    public List<RecipeIngredient> findAll() {
        return entityManager.createQuery("SELECT r FROM RecipeIngredient r", RecipeIngredient.class).getResultList();
    }

    @Override
    @Transactional
    public RecipeIngredient findById(Integer recipeIngredientId) throws ExceptionManager {
        if (recipeIngredientId == null) throw new ExceptionManager("Can not find recipeIngredient by id: " + recipeIngredientId);

        return entityManager.find(RecipeIngredient.class, recipeIngredientId);
    }

    @Override
    @Transactional
    public RecipeIngredient update(RecipeIngredient recipeIngredient) throws ExceptionManager {
        if (recipeIngredient == null) throw new ExceptionManager("Can not update recipeIngredient: " + recipeIngredient);

        return entityManager.merge(recipeIngredient);
    }

    @Override
    @Transactional
    public void clear() {
        entityManager.clear();
    }
}
