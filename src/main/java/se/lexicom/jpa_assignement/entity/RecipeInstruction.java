package se.lexicom.jpa_assignement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class RecipeInstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeInstructionId;
    private String recipeInstructions;

    public RecipeInstruction() {
    }

    public RecipeInstruction(int recipeInstructionId, String recipeInstructions) {
        this.recipeInstructionId = recipeInstructionId;
        this.recipeInstructions = recipeInstructions;
    }

    public RecipeInstruction(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }


    public int getRecipeInstructionId() {
        return recipeInstructionId;
    }

    public void setRecipeInstructionId(int recipeInstructionId) {
        this.recipeInstructionId = recipeInstructionId;
    }

    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return Objects.equals(getRecipeInstructionId(), that.getRecipeInstructionId()) && Objects.equals(getRecipeInstructions(), that.getRecipeInstructions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeInstructionId(), getRecipeInstructions());
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "recipeInstructionId='" + recipeInstructionId + '\'' +
                ", recipeInstructions='" + recipeInstructions + '\'' +
                '}';
    }
}
