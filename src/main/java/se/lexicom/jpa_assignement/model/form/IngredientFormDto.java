package se.lexicom.jpa_assignement.model.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class IngredientFormDto {

    @NotBlank
    @Size(min = 2, max = 50, message = "Exceeded number of characters.")
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
