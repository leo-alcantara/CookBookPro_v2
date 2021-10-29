package se.lexicom.jpa_assignement.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.entity.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
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
    public Ingredient delete(Ingredient ingredient) throws ExceptionManager {
        if (ingredient == null) {
            throw new ExceptionManager("Can not remove item: " + ingredient);
        }
        entityManager.remove(ingredient);
        return ingredient;
    }

    @Override
    @Transactional
    public List<Ingredient> findAll() {
        return entityManager.createQuery("SELECT i FROM Ingredient i", Ingredient.class).getResultList();
    }

    @Override
    @Transactional
    public Ingredient findById(Integer ingredientId) throws ExceptionManager {
        if (ingredientId == null) {
            throw new ExceptionManager("Can not find item: " + ingredientId);
        }
        return entityManager.find(Ingredient.class, ingredientId);
    }

    @Override
    @Transactional
    public Ingredient update(Ingredient ingredient) throws ExceptionManager {
        if (ingredient == null) {
            throw new ExceptionManager("Can not update item: " + ingredient);
        }
        return entityManager.merge(ingredient);
    }

    @Override
    @Transactional
    public void clear() {
        entityManager.clear();
    }


    @Override
    @Transactional
    public Ingredient findIngredientByNameContainsIgnoreCase(String ingredientName) throws ExceptionManager {
        if (ingredientName == null) {
            throw new ExceptionManager("Can not find item: " + ingredientName);
        }
        Optional<Ingredient> ingredient = entityManager.createQuery("SELECT i FROM Ingredient i WHERE UPPER(i.ingredientName) LIKE UPPER(CONCAT('%', :ingredientName, '%') )", Ingredient.class)
                .setParameter("ingredientName", ingredientName).getResultStream().findFirst();

        return ingredient.orElseThrow(() -> new ExceptionManager("Ingredient not found " + ingredientName));
    }

}

