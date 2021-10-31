package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicom.jpa_assignement.DAO.RecipeInstructionDAOImpl;
import se.lexicom.jpa_assignement.dto.RecipeInstructionDto;
import se.lexicom.jpa_assignement.dto.RecipeInstructionFormDto;
import se.lexicom.jpa_assignement.entity.RecipeInstruction;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeInstructionServiceImpl implements RecipeInstructionService {

    private final RecipeInstructionDAOImpl recipeInstructionDAO;
    private final ConversionService convert;

    @Autowired
    public RecipeInstructionServiceImpl(RecipeInstructionDAOImpl recipeInstructionDAO, ConversionService convert) {
        this.recipeInstructionDAO = recipeInstructionDAO;
        this.convert = convert;
    }

    @Override
    @Transactional
    public RecipeInstructionDto createRecipeInstruction(RecipeInstructionFormDto formDto) {
        RecipeInstruction saved = recipeInstructionDAO.create(convert.toRecipeInstruction(formDto));
        return convert.toRecipeInstructionDto(saved);
    }

    @Override
    public RecipeInstructionDto findById(Integer recipeInstructionId) {
        RecipeInstruction foundRecipeInstruction = recipeInstructionDAO.findById(recipeInstructionId);
        return convert.toRecipeInstructionDto(foundRecipeInstruction);
    }

    @Override
    public List<RecipeInstructionDto> findAll() {
        List<RecipeInstruction> recipeInstructionList = recipeInstructionDAO.findAll();
        List<RecipeInstructionDto> recipeInstructionDtoList = new ArrayList<>();
        recipeInstructionList.forEach((ri) -> recipeInstructionDtoList.add(convert.toRecipeInstructionDto(ri)));
        return recipeInstructionDtoList;
    }

    @Override
    public RecipeInstructionDto update(RecipeInstructionFormDto formDto) {
        RecipeInstruction original = recipeInstructionDAO.update(convert.toRecipeInstruction(formDto));
        return convert.toRecipeInstructionDto(original);
    }

    @Override
    public RecipeInstructionDto delete(RecipeInstruction recipeInstruction) {
        recipeInstructionDAO.delete(recipeInstruction);
        return convert.toRecipeInstructionDto(recipeInstruction);
    }

    @Override
    public void clear() {
    }
}
