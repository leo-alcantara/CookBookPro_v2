package se.cookBookProv2.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.cookBookProv2.exceptions.ExceptionManager;
import se.cookBookProv2.entity.RecipeCategory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RecipeCategoryDAOImpl implements RecipeCategoryDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public RecipeCategory create(RecipeCategory recipeCategory) throws ExceptionManager {
        if (recipeCategory == null) {
            throw new ExceptionManager("Can not save recipeCategory: " + recipeCategory);
        }
        entityManager.persist(recipeCategory);
        return recipeCategory;
    }

    @Override
    @Transactional
    public RecipeCategory delete(RecipeCategory recipeCategory) throws ExceptionManager {
        if (recipeCategory == null) {
            throw new ExceptionManager("Can not delete recipeCategory: " + recipeCategory);
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
            throw new ExceptionManager("Can not find recipeCategory with id " + recipeCategoryId);
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

    @Override
    public RecipeCategory findByName(String categoryName) {
        List<RecipeCategory> recipeCategories = entityManager.createQuery("SELECT rc FROM RecipeCategory rc WHERE UPPER(rc.category) LIKE UPPER(CONCAT('%', ?1 , '%'))", RecipeCategory.class)
                .setParameter(1, categoryName).getResultList();
        if (recipeCategories.isEmpty()) {
            return null;
        }
        return recipeCategories.get(0);
    }
}
