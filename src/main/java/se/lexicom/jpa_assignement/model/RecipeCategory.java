package se.lexicom.jpa_assignement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import se.lexicom.jpa_assignement.exceptions.ExceptionManager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeCategoryId;
    private String category;

    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinTable(name = "recipes_categories",
            joinColumns = @JoinColumn(name = "recipe_category_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<Recipe> recipes;

    public RecipeCategory() {
    }

    public RecipeCategory(int recipeCategoryId, String category, List<Recipe> recipes) {
        this.recipeCategoryId = recipeCategoryId;
        this.category = category;
        this.recipes = recipes;
    }

    public RecipeCategory(String category) {
        this.category = category;
    }

    public RecipeCategory(String category, List<Recipe> recipes) {
        this.category = category;
        //this.recipes = recipes;
        for (Recipe r:recipes
        ) {addRecipe(r);

        }
    }


    //Convenience Methods
    public boolean addRecipe(Recipe recipe){
        if(recipe==null) throw new ExceptionManager("Parameter can not be null");
        if(recipes==null)recipes= new ArrayList<>();
        if(!recipes.contains(recipe)){
            recipe.addRecipeCategory(this);
            this.getRecipes().add(recipe);
            return true;
        }
        return false;
    }

    public boolean removeRecipe(Recipe recipe){
        if(recipe==null) throw new ExceptionManager("Parameter can not be null");
        if(recipes==null)recipes= new ArrayList<>();
        if(recipes.contains(recipe)){
            this.recipes.remove(recipe);
            recipe.removeRecipeCategory(null);
            return true;
        }
        return false;
    }

    public int getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public void setRecipeCategoryId(int recipeCategoryId) {
        this.recipeCategoryId = recipeCategoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return Objects.equals(getCategory(), that.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategory());
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "recipeCategoryId=" + recipeCategoryId +
                ", category='" + category + '\'' +
                '}';
    }
}
