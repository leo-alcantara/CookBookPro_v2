package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicom.jpa_assignement.DAO.RecipeInstructionDAOImpl;
import se.lexicom.jpa_assignement.model.RecipeInstruction;

import java.util.List;

@Service
public class RecipeInstructionServiceImpl implements RecipeInstructionService {

    private final RecipeInstructionDAOImpl recipeInstructionDAO;

    @Autowired
    public RecipeInstructionServiceImpl(RecipeInstructionDAOImpl recipeInstructionDAO) {
        this.recipeInstructionDAO = recipeInstructionDAO;
    }

    @Override
    public RecipeInstruction createRecipeInstruction(RecipeInstruction recipeInstruction) {
        return recipeInstructionDAO.create(recipeInstruction);
    }

    @Override
    public RecipeInstruction findById(Integer recipeInstructionId) {
        return recipeInstructionDAO.findById(recipeInstructionId);
    }

    @Override
    public List<RecipeInstruction> findAll() {
        return recipeInstructionDAO.findAll();
    }

    @Override
    public RecipeInstruction update(RecipeInstruction recipeInstruction) {
        return recipeInstructionDAO.update(recipeInstruction);
    }

    @Override
    public RecipeInstruction delete(RecipeInstruction recipeInstruction) {
        return recipeInstructionDAO.delete(recipeInstruction);
    }

    @Override
    public void clear() {
        recipeInstructionDAO.clear();
    }


}
