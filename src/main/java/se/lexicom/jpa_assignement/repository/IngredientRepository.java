package se.lexicom.jpa_assignement.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicom.jpa_assignement.entity.Ingredient;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    List<Ingredient> findByIngredientName(String ingredientName);
}
