package se.cookBookProv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.cookBookProv2.DAO.IngredientDAOImpl;
import se.cookBookProv2.dto.IngredientDto;
import se.cookBookProv2.dto.IngredientFormDto;
import se.cookBookProv2.entity.Ingredient;

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
    public IngredientDto createIngredient(IngredientDto ingredientDto) {
        Ingredient saved = ingredientDAO.create(convert.toIngredient(ingredientDto));
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
    public IngredientDto update(IngredientDto ingredientDto) {
        Ingredient original = ingredientDAO.update(convert.toIngredient(ingredientDto));
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
