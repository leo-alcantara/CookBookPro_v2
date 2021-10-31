package se.lexicom.jpa_assignement.dto;

public class RecipeInstructionFormDto {

    private String recipeInstructions;

    public RecipeInstructionFormDto() {
    }

    public RecipeInstructionFormDto(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    public String getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(String recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

}
