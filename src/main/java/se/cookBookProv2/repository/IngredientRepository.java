package se.cookBookProv2.repository;

import org.springframework.data.repository.CrudRepository;
import se.cookBookProv2.entity.Ingredient;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    List<Ingredient> findByIngredientName(String ingredientName);
}
