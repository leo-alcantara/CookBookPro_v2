package se.lexicom.jpa_assignement.dto;

public class IngredientDto {

    private int ingredientId;
    private String ingredientName;

    public IngredientDto() {
    }

    public IngredientDto(int ingredientId, String ingredientName) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
    }

    public IngredientDto(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public String toString() {
        return "IngredientDto{" +
                "ingredientId=" + ingredientId +
                ", ingredientName='" + ingredientName + '\'' +
                '}';
    }
}
