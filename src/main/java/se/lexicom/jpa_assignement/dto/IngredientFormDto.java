package se.lexicom.jpa_assignement.dto;

public class IngredientFormDto {


    private String ingredientName;

    public IngredientFormDto() {
    }

    public IngredientFormDto(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
