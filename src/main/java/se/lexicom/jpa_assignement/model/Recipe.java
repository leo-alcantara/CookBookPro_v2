package se.lexicom.jpa_assignement.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;

    @OneToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH},
            orphanRemoval = true,
            fetch = FetchType.LAZY,
    mappedBy = "recipe")
    private List<RecipeIngredient> ingredients;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_instruction_id")
    private RecipeInstruction instructions;

    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinTable(name = "recipes_categories",
            joinColumns = @JoinColumn(name = "recipe_id"),
    inverseJoinColumns = @JoinColumn(name = "recipe_category_id"))
    private List<RecipeCategory> categories;

    public Recipe() {
    }

    public Recipe(String recipeName, List<RecipeIngredient> ingredients,
                  RecipeInstruction instructions, List<RecipeCategory> categories) {
        this.recipeName = recipeName;
        setIngredients(ingredients);
        setInstructions(instructions);
        setCategories(categories);
    }

    //Convenience Methods
    public void addRecipeIngredient(RecipeIngredient recipeIngredient){
        ingredients.add(recipeIngredient);
        recipeIngredient.setRecipe(this);
    }

    public void removeRecipeIngredients(RecipeIngredient recipeIngredient){
        recipeIngredient.setRecipe(null);
        ingredients.remove(recipeIngredient);
    }

    public void addRecipeCategory (RecipeCategory recipeCategory){
        if(!categories.contains(recipeCategory)){
            categories.add(recipeCategory);
        }
    }

    public void removeRecipeCategory(RecipeCategory recipeCategory){
        if(categories.contains(recipeCategory)){
            categories.remove(recipeCategory);
        }
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public RecipeInstruction getInstructions() {
        return instructions;
    }

    public void setInstructions(RecipeInstruction instructions) {
        this.instructions = instructions;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(getRecipeName(), recipe.getRecipeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeName());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                '}';
    }
}
