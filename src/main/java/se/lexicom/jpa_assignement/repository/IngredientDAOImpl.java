package se.lexicom.jpa_assignement.repository;

import org.springframework.stereotype.Repository;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.model.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Repository
public class IngredientDAOImpl implements IngredientDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Ingredient create(Ingredient ingredient) throws ExceptionManager {
        if (ingredient == null) {
            throw new ExceptionManager("Can not persist item: " + ingredient);
        }
        entityManager.persist(ingredient);
        return ingredient;
    }

    @Override
    @Transactional
    public Ingredient delete(Ingredient ingredient) {
        entityManager.remove(ingredient);
        return ingredient;
    }

    @Override
    @Transactional
    public Collection<Ingredient> findAll() {
        Query query = entityManager.createQuery("SELECT i FROM Ingredient i");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Ingredient findById(Integer integer) {
        Ingredient ingredient = entityManager.find(Ingredient.class, integer);
        return ingredient;
    }

    @Override
    @Transactional
    public Ingredient update(Ingredient ingredient) {
        return entityManager.merge(ingredient);
    }

    @Override
    @Transactional
    public void clear() {
        entityManager.clear();
    }

    @Override
    @Transactional
    public Ingredient findIngredientByName(String ingredientName) throws ExceptionManager {
        if (ingredientName == null) {
            throw new ExceptionManager("Can not find item: " + ingredientName);
        }
        Optional<Ingredient> ingredient = entityManager.createQuery("SELECT i FROM Ingredient i WHERE i.ingredientName = ?1", Ingredient.class)
                .setParameter(1, ingredientName).getResultStream().findFirst();

        return ingredient.orElseThrow(() -> new ExceptionManager("Ingredient not found"));
    }

    @Override
    @Transactional
    public Ingredient findIngredientByNameContain(String ingredientName) throws ExceptionManager {
        if (ingredientName == null) {
            throw new ExceptionManager("Can not find item: " + ingredientName);
        }
        Optional<Ingredient> ingredient = entityManager.createQuery("SELECT i FROM Ingredient i WHERE UPPER(i.ingredientName) LIKE UPPER(CONCAT('%', :ingredientName, '%') )", Ingredient.class)
                .setParameter("ingredientName", ingredientName).getResultStream().findFirst();

        return ingredient.orElseThrow(() -> new ExceptionManager("Ingredient not found"));
    }

}

