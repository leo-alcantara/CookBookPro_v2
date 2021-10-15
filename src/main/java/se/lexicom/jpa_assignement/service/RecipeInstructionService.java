package se.lexicom.jpa_assignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicom.jpa_assignement.DAO.RecipeInstructionDAOImpl;
import se.lexicom.jpa_assignement.model.RecipeInstruction;

import java.util.List;

@Service
public class RecipeInstructionService {

    private final RecipeInstructionDAOImpl recipeInstructionDAO;

    @Autowired
    public RecipeInstructionService(RecipeInstructionDAOImpl recipeInstructionDAO) {
        this.recipeInstructionDAO = recipeInstructionDAO;
    }

    public RecipeInstruction createRecipeInstruction(RecipeInstruction recipeInstruction) {
        return recipeInstructionDAO.create(recipeInstruction);
    }

    public RecipeInstruction findById(Integer recipeInstructionId) {
        return recipeInstructionDAO.findById(recipeInstructionId);
    }

    public List<RecipeInstruction> findAll() {
        return recipeInstructionDAO.findAll();
    }

    public RecipeInstruction update(RecipeInstruction recipeInstruction) {
        return recipeInstructionDAO.update(recipeInstruction);
    }

    public RecipeInstruction delete(RecipeInstruction recipeInstruction) {
        return recipeInstructionDAO.delete(recipeInstruction);
    }

    public void clear() {
        recipeInstructionDAO.clear();
    }


}
