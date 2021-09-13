package se.lexicom.jpa_assignement.repository;

import org.springframework.stereotype.Repository;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.model.RecipeInstruction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class RecipeInstructionDAOImpl implements RecipeInstructionDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public RecipeInstruction create(RecipeInstruction recipeInstruction) throws ExceptionManager {
        if (recipeInstruction == null) {
            throw new ExceptionManager("Can not persist item: " + recipeInstruction);
        }
        entityManager.persist(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    @Transactional
    public RecipeInstruction delete(RecipeInstruction recipeInstruction) {
        entityManager.remove(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    @Transactional
    public Collection<RecipeInstruction> findAll() {
        Query query = entityManager.createQuery("SELECT r FROM RecipeInstruction r");
        return query.getResultList();
    }

    @Override
    @Transactional
    public RecipeInstruction findById(String recipeInstructionId) {
        RecipeInstruction recipeInstruction = entityManager.find(RecipeInstruction.class, recipeInstructionId);
        return recipeInstruction;
    }

    @Override
    @Transactional
    public RecipeInstruction update(RecipeInstruction recipeInstruction) {
        return entityManager.merge(recipeInstruction);
    }

    @Override
    @Transactional
    public void clear() {
        entityManager.clear();
    }

}
