package se.lexicom.jpa_assignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicom.jpa_assignement.dto.RecipeIngredientDto;
import se.lexicom.jpa_assignement.dto.RecipeIngredientFormDto;
import se.lexicom.jpa_assignement.entity.RecipeIngredient;
import se.lexicom.jpa_assignement.service.RecipeIngredientServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/recipe-ingredient")
@CrossOrigin("*")
public class RecipeIngredientControllerImpl implements RecipeIngredientController {

    private final RecipeIngredientServiceImpl recipeIngredientServiceImpl;

    @Autowired
    public RecipeIngredientControllerImpl(RecipeIngredientServiceImpl recipeIngredientServiceImpl) {
        this.recipeIngredientServiceImpl = recipeIngredientServiceImpl;
    }

    @Override
    @PostMapping
    public ResponseEntity<RecipeIngredientDto> createRecipeIngredient(@RequestBody @Valid RecipeIngredientFormDto formDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeIngredientServiceImpl.createRecipeIngredient(formDto));
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<RecipeIngredientDto> findById(@PathVariable("id") Integer recipeIngredientId) {
        return ResponseEntity.ok(recipeIngredientServiceImpl.findById(recipeIngredientId));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<RecipeIngredientDto>> findAll() {
        return ResponseEntity.ok(recipeIngredientServiceImpl.findAll());
    }

    @Override
    @PutMapping
    public ResponseEntity<RecipeIngredientDto> update(@RequestBody @Valid RecipeIngredientFormDto formDto) {
            return ResponseEntity.ok().body(recipeIngredientServiceImpl.update(formDto));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping
    public ResponseEntity<RecipeIngredientDto> delete(@RequestBody RecipeIngredient recipeIngredient) {
        return ResponseEntity.ok(recipeIngredientServiceImpl.delete(recipeIngredient));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping(path = "/clear")
    public ResponseEntity<Void> clear() {
        recipeIngredientServiceImpl.clear();
        return ResponseEntity.ok().build();
    }


}
