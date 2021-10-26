package se.lexicom.jpa_assignement.service;

import org.springframework.stereotype.Component;
import se.lexicom.jpa_assignement.dto.*;
import se.lexicom.jpa_assignement.model.form.*;
import se.lexicom.jpa_assignement.model.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConversionService {

    //INGREDIENT CONVERTER
    public Ingredient toIngredient(IngredientFormDto formDto){
        return new Ingredient(0, formDto.getIngredientName());
    }

    public IngredientDto toIngredientDto(Ingredient ingredient){
        return new IngredientDto(ingredient.getIngredientId(), ingredient.getIngredientName());
    }

    //RECIPE CATEGORY CONVERTER
    public RecipeCategory toRecipeCategory(RecipeCategoryFormDto formDto){
        return new RecipeCategory(0, formDto.getCategory(), new ArrayList<>());
    }

    public RecipeCategoryDto toRecipeCategoryDto(RecipeCategory recipeCategory){
        return new RecipeCategoryDto(recipeCategory.getRecipeCategoryId(), recipeCategory.getCategory(), new ArrayList<>());
    }

    //RECIPE INGREDIENT CONVERTER
    public RecipeIngredient toRecipeIngredient(RecipeIngredientFormDto formDto){
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();
        for (RecipeIngredient ri: recipeIngredients){
            RecipeIngredient recipeIngredient = new RecipeIngredient(ri.getIngredient(), ri.getAmount(), ri.getMeasurement(), ri.getRecipe());
            recipeIngredients.add(recipeIngredient);
        }
        List<RecipeCategory> recipeCategories = new ArrayList<>();
        for (RecipeCategory rc: recipeCategories){
            RecipeCategory recipeCategory = new RecipeCategory(rc.getCategory());
            recipeCategories.add(recipeCategory);
        }
        RecipeInstruction recipeInstruction = new RecipeInstruction(formDto.getRecipe().getInstructions());
        Recipe recipe = new Recipe(formDto.getRecipe().getRecipeName(), recipeIngredients, recipeInstruction, recipeCategories);
        return new RecipeIngredient(0,formDto.getIngredient(), formDto.getAmount(),
                formDto.getMeasurement(), recipe);
    }

    public RecipeIngredientDto toRecipeIngredientDto(RecipeIngredient recipeIngredient){
        IngredientDto ingredientDto = new IngredientDto(0, recipeIngredient.getIngredient().getIngredientName());
        return new RecipeIngredientDto(ingredientDto, recipeIngredient.getAmount(), recipeIngredient.getMeasurement());
    }

    //RECIPE INSTRUCTION CONVERTER
    /*public RecipeInstruction toRecipeInstruction (RecipeInstructionFormDto formDto){
        return new RecipeInstruction(0, formDto.getRecipeInstructions());
    }*/

    public RecipeInstructionDto toRecipeInstructionDto(RecipeInstruction recipeInstruction){
        return new RecipeInstructionDto(recipeInstruction.getRecipeInstructionId(), recipeInstruction.getRecipeInstructions());
    }

    //RECIPE CONVERTER
    public Recipe toRecipe(RecipeFormDto formDto){
        RecipeInstruction instruction = new RecipeInstruction(0, formDto.getInstructions());
        List<RecipeCategory> categories = new ArrayList<>();
        for (RecipeCategory rc: categories){
            RecipeCategory recipeCategory = new RecipeCategory(rc.getCategory());
            categories.add(recipeCategory);
        }
        List<RecipeIngredient> recipeIngredientList = new ArrayList<>();
        for (RecipeIngredientFormDto ri: formDto.getIngredients()){
            RecipeIngredient recipeIngredient = new RecipeIngredient(new Ingredient(ri.getIngredient().getIngredientName()),
                    ri.getAmount(), ri.getMeasurement());
            recipeIngredientList.add(recipeIngredient);
        }

        Recipe recipe = new Recipe(formDto.getRecipeName(), recipeIngredientList, instruction, categories);
        for (RecipeIngredient ri: recipeIngredientList){
            recipe.addRecipeIngredient(ri);
        }
        for (RecipeCategory rc: categories){
            recipe.addRecipeCategory(rc);
        }
        return recipe;
    }

    public RecipeDto toRecipeDto(Recipe recipe){
        List<RecipeIngredientDto> ingredientsDto = new ArrayList<>();
        for (RecipeIngredient ri: recipe.getIngredients()){
            ingredientsDto.add(toRecipeIngredientDto(ri));
        }
        RecipeInstructionDto recipeInstructionDto = new RecipeInstructionDto(recipe.getInstructions().getRecipeInstructionId(), recipe.getInstructions().getRecipeInstructions());

        List<RecipeCategoryDto> recipeCategoryDtoList = new ArrayList<>();
        for(RecipeCategory recipeCategory : recipe.getCategories()){
            recipeCategoryDtoList.add(toRecipeCategoryDto(recipeCategory));
        }
        return new RecipeDto(recipe.getRecipeName(), ingredientsDto, recipeInstructionDto, recipeCategoryDtoList);
    }
}
