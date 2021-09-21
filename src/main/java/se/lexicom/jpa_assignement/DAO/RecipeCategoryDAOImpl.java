package se.lexicom.jpa_assignement.DAO;

import org.springframework.stereotype.Repository;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.model.RecipeCategory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RecipeCategoryDAOImpl implements RecipeCategoryDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public RecipeCategory create(RecipeCategory recipeCategory) throws ExceptionManager {
        if (recipeCategory == null) {
            throw new ExceptionManager("Can not save item: " + recipeCategory);
        }
        entityManager.persist(recipeCategory);
        return recipeCategory;
    }

    @Override
    @Transactional
    public RecipeCategory delete(RecipeCategory recipeCategory) throws ExceptionManager {
        if (recipeCategory == null) {
            throw new ExceptionManager("Can not delete item: " + recipeCategory);
        }
        entityManager.remove(recipeCategory);
        return recipeCategory;
    }

    @Override
    @Transactional
    public List<RecipeCategory> findAll() {
        return entityManager.createQuery("SELECT rc FROM RecipeCategory rc", RecipeCategory.class).getResultList();
    }

    @Override
    @Transactional
    public RecipeCategory findById(Integer recipeCategoryId) throws ExceptionManager {
        if (recipeCategoryId == null) {
            throw new ExceptionManager("Can not delete item: " + recipeCategoryId);
        }
        return entityManager.find(RecipeCategory.class, recipeCategoryId);
    }

    @Override
    @Transactional
    public RecipeCategory update(RecipeCategory recipeCategory) {
        return entityManager.merge(recipeCategory);
    }

    @Override
    @Transactional
    public void clear() {
        entityManager.clear();
    }
}
