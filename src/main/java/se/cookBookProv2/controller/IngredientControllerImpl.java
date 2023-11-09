package se.cookBookProv2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.cookBookProv2.dto.IngredientDto;
import se.cookBookProv2.dto.IngredientFormDto;
import se.cookBookProv2.entity.Ingredient;
import se.cookBookProv2.service.IngredientServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/ingredients")
@CrossOrigin("*")
public class IngredientControllerImpl implements IngredientController {

    private final IngredientServiceImpl ingredientServiceImpl;

    @Autowired
    public IngredientControllerImpl(IngredientServiceImpl ingredientServiceImpl) {
        this.ingredientServiceImpl = ingredientServiceImpl;
    }

    @Override
    @PostMapping
    public ResponseEntity<IngredientDto> createIngredient(@RequestBody @Valid IngredientDto ingredientDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ingredientServiceImpl.createIngredient(ingredientDto));
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<IngredientDto> findById(@PathVariable("id") Integer ingredientId) {
        return ResponseEntity.ok(ingredientServiceImpl.findById(ingredientId));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<IngredientDto>> findAll() {
        return ResponseEntity.ok(ingredientServiceImpl.findAll());
    }

    @Override
    @PutMapping
    public ResponseEntity<IngredientDto> update(@RequestBody @Valid IngredientDto ingredientDto) {
            return ResponseEntity.ok().body(ingredientServiceImpl.update(ingredientDto));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping
    public ResponseEntity<IngredientDto> delete(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok(ingredientServiceImpl.delete(ingredient));
    }

    //NOT SURE IF THIS IS RIGHT
    @Override
    @DeleteMapping("/clear")
    public ResponseEntity<Void> clear() {
        ingredientServiceImpl.clear();
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping("/{ingredient-name}")
    public ResponseEntity<IngredientDto> findIngredientByNameContainsIgnoreCase(@PathVariable("ingredient-name") String ingredientName) {
        return ResponseEntity.ok(ingredientServiceImpl.findIngredientByNameContainsIgnoreCase(ingredientName));
    }


}
