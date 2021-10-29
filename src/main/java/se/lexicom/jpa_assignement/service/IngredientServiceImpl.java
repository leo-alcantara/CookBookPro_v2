package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.DAO.IngredientDAOImpl;
import se.lexicom.jpa_assignement.dto.IngredientDto;
import se.lexicom.jpa_assignement.dto.IngredientFormDto;
import se.lexicom.jpa_assignement.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientDAOImpl ingredientDAO;
    private final ConversionService convert;

    @Autowired
    public IngredientServiceImpl(IngredientDAOImpl ingredientDAO, ConversionService convert) {
        this.ingredientDAO = ingredientDAO;
        this.convert = convert;
    }

    @Override
    @Transactional
    public IngredientDto createIngredient(IngredientFormDto form) {
        Ingredient saved = ingredientDAO.create(convert.toIngredient(form));
        return convert.toIngredientDto(saved);
    }

    @Override
    @Transactional
    public IngredientDto findById(Integer ingredientId) {
        Ingredient fondIngredient = ingredientDAO.findById(ingredientId);
        return convert.toIngredientDto(fondIngredient);
    }

    @Override
    @Transactional
    public List<IngredientDto> findAll() {
        List<Ingredient> ingredientList = ingredientDAO.findAll();
        List<IngredientDto> ingredientDtoList = new ArrayList<>();
        ingredientList.forEach((i) -> ingredientDtoList.add(convert.toIngredientDto(i)));
        return ingredientDtoList;
    }

    @Override
    @Transactional
    public IngredientDto update(IngredientFormDto formDto) {
        Ingredient original = ingredientDAO.update(convert.toIngredient(formDto));
        return convert.toIngredientDto(original);
    }

    @Override
    @Transactional
    public IngredientDto delete(Ingredient ingredient) {
        ingredientDAO.delete(ingredient);
        return convert.toIngredientDto(ingredient);
    }

    @Override
    @Transactional
    public void clear() {
        ingredientDAO.clear();
    }

    @Override
    @Transactional
    public IngredientDto findIngredientByNameContainsIgnoreCase(String ingredientName) {
        Ingredient foundIngredient = ingredientDAO.findIngredientByNameContainsIgnoreCase(ingredientName);
        return convert.toIngredientDto(foundIngredient);
    }
}
