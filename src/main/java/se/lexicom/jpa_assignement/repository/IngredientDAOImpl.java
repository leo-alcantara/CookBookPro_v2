package se.lexicom.jpa_assignement.repository;

import org.springframework.stereotype.Repository;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.model.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Optional;

@Repository
public class IngredientDAOImpl implements IngredientDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Ingredient create(Ingredient ingredient) throws ExceptionManager {
        if (ingredient == null) {
            throw new ExceptionManager("Can not persist item: " + ingredient);
        }
        entityManager.persist(ingredient);
        return ingredient;
    }

    @Override
    public Ingredient delete(Ingredient ingredient) {
        entityManager.remove(ingredient);
        return ingredient;
    }

    @Override
    public Collection<Ingredient> findAll() {
        Query query = entityManager.createQuery("SELECT r FROM Ingredient r");
        return query.getResultList();
    }

    @Override
    public Ingredient findById(Integer integer) {
        Ingredient ingredient = entityManager.find(Ingredient.class, integer);
        return ingredient;
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        return entityManager.merge(ingredient);
    }

    @Override
    public void clear() {
        entityManager.clear();
    }

    @Override
    public Ingredient findIngredientByName(String ingredientName) throws ExceptionManager {
        if (ingredientName == null) {
            throw new ExceptionManager("Can not find item: " + ingredientName);
        }
        Optional<Ingredient> ingredient = entityManager.createQuery("SELECT r FROM Ingredient r WHERE r.ingredientName = ?1", Ingredient.class)
                .setParameter(1, ingredientName).getResultStream().findFirst();

        return ingredient.orElseThrow(() -> new ExceptionManager("Ingredient not found"));
    }

    @Override
    public Ingredient findIngredientByNameContain(String ingredientName) {
        return null;
    }
}
