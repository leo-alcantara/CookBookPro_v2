package se.lexicom.jpa_assignement.service;

import org.springframework.stereotype.Component;
import se.lexicom.jpa_assignement.dto.*;
import se.lexicom.jpa_assignement.entity.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ConversionService {

    //INGREDIENT CONVERTER
    public Ingredient toIngredient(IngredientFormDto formDto) {
        return new Ingredient(0, formDto.getIngredientName());
    }

    public IngredientDto toIngredientDto(Ingredient ingredient) {
        return new IngredientDto(ingredient.getIngredientId(), ingredient.getIngredientName());
    }


    //RECIPE CATEGORY CONVERTER
    public RecipeCategory toRecipeCategory(RecipeCategoryFormDto formDto) {
        return new RecipeCategory(0, formDto.getCategory(), new ArrayList<>());
    }

    public RecipeCategoryDto toRecipeCategoryDto(RecipeCategory recipeCategory) {

        return toRecipeCategoryDto(recipeCategory, true);
    }

    private RecipeCategoryDto toRecipeCategoryDto(RecipeCategory recipeCategory, boolean convertRecipes) {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        if (convertRecipes) {
            for (Recipe recipe : recipeCategory.getRecipes()) {
                RecipeDto recipeDto = toRecipeDto(recipe);
                recipeDtoList.add(recipeDto);
            }
        }
        return new RecipeCategoryDto(recipeCategory.getRecipeCategoryId(), recipeCategory.getCategory());
    }


    //RECIPE INGREDIENT CONVERTER
    public RecipeIngredient toRecipeIngredient(RecipeIngredientFormDto formDto) {
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();
        for (RecipeIngredient ri : recipeIngredients) {
            RecipeIngredient recipeIngredient = new RecipeIngredient(ri.getIngredient(), ri.getAmount(),
                    ri.getMeasurement(), ri.getRecipe());
            recipeIngredients.add(recipeIngredient);
        }
        Set<RecipeCategory> recipeCategories = new HashSet<>();
        for (RecipeCategory rc : recipeCategories) {
            RecipeCategory recipeCategory = new RecipeCategory(rc.getCategory());
            recipeCategories.add(recipeCategory);
        }
        RecipeInstruction recipeInstruction = new RecipeInstruction(formDto.getRecipe().getInstructions());
        Recipe recipe = new Recipe(formDto.getRecipe().getRecipeName(), recipeIngredients, recipeInstruction, recipeCategories);
        Ingredient ingredient = new Ingredient(formDto.getIngredient());
        return new RecipeIngredient(0, ingredient, formDto.getAmount(),
                formDto.getMeasurement(), recipe);
    }

    public RecipeIngredientDto toRecipeIngredientDto(RecipeIngredient recipeIngredient) {
        return new RecipeIngredientDto(recipeIngredient.getRecipeIngredientId(), toIngredientDto(recipeIngredient.getIngredient()), recipeIngredient.getAmount(), recipeIngredient.getMeasurement());
    }


    //RECIPE INSTRUCTION CONVERTER
    public RecipeInstruction toRecipeInstruction(RecipeInstructionFormDto formDto) {
        return new RecipeInstruction(0, formDto.getRecipeInstructions());
    }

    public RecipeInstructionDto toRecipeInstructionDto(RecipeInstruction recipeInstruction) {
        return new RecipeInstructionDto(recipeInstruction.getRecipeInstructionId(), recipeInstruction.getRecipeInstructions());
    }


    //RECIPE CONVERTER
    public Recipe toRecipe(RecipeFormDto formDto) {
        RecipeInstruction instruction = new RecipeInstruction(0, formDto.getInstructions());
        Set<RecipeCategory> categories = new HashSet<>();
        for (String categoryNames : formDto.getCategories()) {
            for (RecipeCategory rc : categories) {
                RecipeCategory recipeCategory = new RecipeCategory(rc.getRecipeCategoryId(), categoryNames, rc.getRecipes());
                categories.add(recipeCategory);
            }
        }
        List<RecipeIngredient> recipeIngredientList = new ArrayList<>();
        for (RecipeIngredientFormDto ri : formDto.getIngredients()) {
            RecipeIngredient recipeIngredient = new RecipeIngredient(new Ingredient(ri.getIngredient()),
                    ri.getAmount(), ri.getMeasurement());
            recipeIngredientList.add(recipeIngredient);
        }
        Recipe recipe = new Recipe(formDto.getRecipeName(), recipeIngredientList, instruction, categories);
        return recipe;
    }

    public RecipeDto toRecipeDto(Recipe recipe) {
        System.out.println("recipe.getIngrediants() = " + recipe.getIngredients());
        List<RecipeIngredientDto> ingredientsDto = new ArrayList<>();
        for (RecipeIngredient ri : recipe.getIngredients()) {
            ingredientsDto.add(toRecipeIngredientDto(ri));
        }
        RecipeInstructionDto recipeInstructionDto = new RecipeInstructionDto(recipe.getInstructions().getRecipeInstructionId(),
                recipe.getInstructions().getRecipeInstructions());

        List<RecipeCategoryDto> recipeCategoryDtoList = new ArrayList<>();
        for (RecipeCategory recipeCategory : recipe.getCategories()) {
            recipeCategoryDtoList.add(toRecipeCategoryDto(recipeCategory, false));
        }
        RecipeDto result = new RecipeDto(recipe.getRecipeId(), recipe.getRecipeName(), ingredientsDto, recipeInstructionDto, recipeCategoryDtoList);
        System.out.println("result.getIngredients() = " + result.getIngredients());
        return result;
    }
}
