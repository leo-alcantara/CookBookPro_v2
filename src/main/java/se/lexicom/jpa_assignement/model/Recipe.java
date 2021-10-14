package se.lexicom.jpa_assignement.model;

import se.lexicom.jpa_assignement.exceptions.ExceptionManager;

import javax.persistence.*;
import java.util.ArrayList;
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

        for (RecipeIngredient i:ingredients
             ) {addRecipeIngredient(i);
        }
        setInstructions(instructions);

        for (RecipeCategory c:categories
             ) {addRecipeCategory(c);
        }
    }

    //Convenience Methods
    public boolean addRecipeIngredient(RecipeIngredient recipeIngredient){
        if(recipeIngredient==null) throw new ExceptionManager("Parameter can not be null");
        if(ingredients==null)ingredients= new ArrayList<>();
        if(!ingredients.contains(recipeIngredient)){
            recipeIngredient.setRecipe(this);
            this.getIngredients().add(recipeIngredient);
            return true;
        }
        return false;
    }

    public boolean removeRecipeIngredients(RecipeIngredient recipeIngredient){
        if(recipeIngredient==null) throw new ExceptionManager("Parameter can not be null");
        if(ingredients==null)ingredients= new ArrayList<>();
        if(ingredients.contains(recipeIngredient)){
            this.ingredients.remove(recipeIngredient);
            recipeIngredient.setRecipe(null);
            return true;
        }
       return false;
    }

    public boolean addRecipeCategory (RecipeCategory recipeCategory){
        if(recipeCategory==null) throw new ExceptionManager("Parameter can not be null");
        if(categories==null)categories= new ArrayList<>();
        if(!categories.contains(recipeCategory)){
            recipeCategory.getRecipes().add(this);
            categories.add(recipeCategory);
            return true;
        }
        return false;
    }

    public void removeRecipeCategory(RecipeCategory recipeCategory){
        if(recipeCategory==null) throw new ExceptionManager("Parameter can not be null");
        if(categories==null)categories= new ArrayList<>();
        if(categories.contains(recipeCategory)){
            this.categories.remove(recipeCategory);
            recipeCategory.getRecipes().remove(this);
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
