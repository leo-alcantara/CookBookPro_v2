package se.cookBookProv2.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.cookBookProv2.exceptions.ExceptionManager;
import se.cookBookProv2.entity.RecipeInstruction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class RecipeInstructionDAOImpl implements RecipeInstructionDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public RecipeInstruction create(RecipeInstruction recipeInstruction) throws ExceptionManager {
        if (recipeInstruction == null) throw new ExceptionManager("Can not persist recipeInstruction: " + recipeInstruction);

        entityManager.persist(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    @Transactional
    public RecipeInstruction delete(RecipeInstruction recipeInstruction) throws ExceptionManager {
        if (recipeInstruction == null) throw new ExceptionManager("Can not delete recipeInstruction: " + recipeInstruction);

        entityManager.remove(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    @Transactional
    public List<RecipeInstruction> findAll() {
        return entityManager.createQuery("SELECT r FROM RecipeInstruction r", RecipeInstruction.class).getResultList();
    }

    @Override
    @Transactional
    public RecipeInstruction findById(Integer recipeInstructionId) throws ExceptionManager {
        if (recipeInstructionId == null) throw new ExceptionManager("Can not find recipeInstruction by id: " + recipeInstructionId);

        return entityManager.find(RecipeInstruction.class, recipeInstructionId);
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
