package se.cookBookProv2.entity;

import se.cookBookProv2.exceptions.ExceptionManager;

import javax.persistence.*;
import java.util.*;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;
    private String recipeName;

    @OneToMany(cascade = {CascadeType.PERSIST,
            CascadeType.REMOVE,
            CascadeType.DETACH,
            CascadeType.REFRESH},
            orphanRemoval = true,
            fetch = FetchType.LAZY/*,
    mappedBy = "recipe"*/)
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
    private Set<RecipeCategory> categories;

    public Recipe() {
    }

    public Recipe(int recipeId, String recipeName, List<RecipeIngredient> ingredients,
                  RecipeInstruction instructions, Set<RecipeCategory> categories) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.categories = categories;
    }

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
    }

    public Recipe(String recipeName, List<RecipeIngredient> ingredients, RecipeInstruction instructions,
                  Set<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.categories = categories;
    }


    //Convenience Methods. They are not correct according to Mehrdad
    public boolean addRecipeIngredient(RecipeIngredient recipeIngredient) {
        if (recipeIngredient == null) throw new ExceptionManager("Parameter can not be null");
        if (ingredients == null) ingredients = new ArrayList<>();
        if (!ingredients.contains(recipeIngredient)) {
            recipeIngredient.setRecipe(this);
            ingredients.add(recipeIngredient);
            return true;
        }
        return false;
    }

    public boolean removeRecipeIngredients(RecipeIngredient recipeIngredient) {
        if (recipeIngredient == null) throw new ExceptionManager("Parameter can not be null");
        if (ingredients == null) ingredients = new ArrayList<>();
        if (ingredients.contains(recipeIngredient)) {
            this.ingredients.remove(recipeIngredient);
            recipeIngredient.setRecipe(null);
            return true;
        }
        return false;
    }

    public boolean addRecipeCategory(RecipeCategory recipeCategory) {
        if (recipeCategory == null) throw new ExceptionManager("Parameter can not be null");
        if (categories == null) categories = new HashSet<>();
        if (!categories.contains(recipeCategory)) {
            recipeCategory.getRecipes().add(this);
            categories.add(recipeCategory);
            return true;
        }
        return false;
    }

    public void removeRecipeCategory(RecipeCategory recipeCategory) {
        if (recipeCategory == null) throw new ExceptionManager("Parameter can not be null");
        if (categories == null) categories = new HashSet<>();
        if (categories.contains(recipeCategory)) {
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

    public Set<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<RecipeCategory> categories) {
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
