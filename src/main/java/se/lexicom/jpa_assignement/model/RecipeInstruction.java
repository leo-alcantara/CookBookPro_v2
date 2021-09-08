package se.lexicom.jpa_assignement.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class RecipeInstruction {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String recipeInstructionId;
    private String recipeInstructions;

    public RecipeInstruction() {
    }

    public RecipeInstruction(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    public String getRecipeInstructionId() {
        return recipeInstructionId;
    }

    public void setRecipeInstructionId(String recipeInstructionId) {
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
        return Objects.equals(getRecipeInstructions(), that.getRecipeInstructions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeInstructions());
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "recipeInstructionId='" + recipeInstructionId + '\'' +
                ", recipeInstructions='" + recipeInstructions + '\'' +
                '}';
    }
}
