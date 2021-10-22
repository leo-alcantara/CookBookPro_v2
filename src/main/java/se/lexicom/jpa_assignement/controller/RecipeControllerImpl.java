package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.dto.RecipeDto;
import se.lexicom.jpa_assignement.model.form.RecipeFormDto;
import se.lexicom.jpa_assignement.model.Recipe;
import se.lexicom.jpa_assignement.service.RecipeServiceImpl;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@CrossOrigin("*")
public class RecipeControllerImpl implements RecipeController {

    private final RecipeServiceImpl recipeServiceImpl;

    @Autowired
    public RecipeControllerImpl(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @Override
    @PostMapping
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody @Valid RecipeFormDto formDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeServiceImpl.createRecipe(formDto));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> findById(@PathVariable("id") Integer recipeId) {
        return ResponseEntity.ok(recipeServiceImpl.findById(recipeId));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<RecipeDto>> findAll() {
        return ResponseEntity.ok(recipeServiceImpl.findAll());
    }

    @Override
    @PutMapping
    public ResponseEntity<RecipeDto> update(@RequestBody @Valid RecipeFormDto formDto) {
            return ResponseEntity.ok().body(recipeServiceImpl.update(formDto));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping
    public ResponseEntity<RecipeDto> delete(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeServiceImpl.delete(recipe));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping(path = "/clear")
    public ResponseEntity<Void> clear() {
        recipeServiceImpl.clear();
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping(path = "{recipe-name}")
    public ResponseEntity<List<RecipeDto>> findRecipeByNameContainsIgnoreCase(@PathVariable("recipe-name") String recipeName) {
        return ResponseEntity.ok(recipeServiceImpl.findRecipeByNameContainsIgnoreCase(recipeName));
    }

    @Override
    @GetMapping(path = "/{ingredient-name}")
    public ResponseEntity<List<RecipeDto>> findRecipeByIngredientNameContainsIgnoreCase(@PathVariable("ingredient-name") String ingredientName) {
        return ResponseEntity.ok(recipeServiceImpl.findRecipeByIngredientNameContainsIgnoreCase(ingredientName));
    }

    @Override
    @GetMapping(path = "{category-name}")
    public ResponseEntity<List<RecipeDto>> findRecipeByCategoryContainsIgnoreCase(@PathVariable("category-name") String categoryName) {
        return ResponseEntity.ok(recipeServiceImpl.findRecipeByCategoryContainsIgnoreCase(categoryName));
    }

    @Override
    @GetMapping(path = "/{recipe-categories}")
    public ResponseEntity<List<RecipeDto>> findRecipeSeveralCategories(@PathVariable("recipe-categories") Collection<String> recipeCategories) {
        return ResponseEntity.ok(recipeServiceImpl.findRecipeSeveralCategories(recipeCategories));
    }
}
