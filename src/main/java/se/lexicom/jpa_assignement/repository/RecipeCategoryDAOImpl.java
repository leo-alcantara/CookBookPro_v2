package se.lexicom.jpa_assignement.repository;

import org.springframework.stereotype.Repository;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;
import se.lexicom.jpa_assignement.model.RecipeCategory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

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
    public Collection<RecipeCategory> findAll() {
        Query query = entityManager.createQuery("SELECT rc FROM RecipeCategory rc");
        return query.getResultList();
    }

    @Override
    @Transactional
    public RecipeCategory findById(Integer integer) {
        RecipeCategory recipeCategory = entityManager.find(RecipeCategory.class, integer);
        return recipeCategory;
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
