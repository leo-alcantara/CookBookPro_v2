package se.cookBookProv2.service;

import org.springframework.stereotype.Component;
import se.cookBookProv2.dto.*;
import se.cookBookProv2.entity.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ConversionService {

    //INGREDIENT CONVERTER
    public Ingredient toIngredient(IngredientDto ingredientDto) {
        return new Ingredient(0, ingredientDto.getIngredientName());
    }

    public IngredientDto toIngredientDto(Ingredient ingredient) {
        return new IngredientDto(ingredient.getIngredientId(), ingredient.getIngredientName());
    }

    //RECIPE CATEGORY CONVERTER
    public RecipeCategory toRecipeCategory(RecipeCategoryDto recipeCategoryDto) {
        List<Recipe> categories = new ArrayList<>();
        if (recipeCategoryDto.getRecipes().size() > 0) {
            for (RecipeDto recipeDto : recipeCategoryDto.getRecipes()) {
                Recipe recipe = toRecipe(recipeDto);
                categories.add(recipe);
            }
        }
        return new RecipeCategory(0, recipeCategoryDto.getCategory(), categories);
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
        return new RecipeCategoryDto(recipeCategory.getRecipeCategoryId(), recipeCategory.getCategory(), recipeDtoList);
    }


    //RECIPE INGREDIENT CONVERTER
    public RecipeIngredient toRecipeIngredient(RecipeIngredientDto recipeIngredientDto) {

        return new RecipeIngredient(0,
                toIngredient(recipeIngredientDto.getIngredient()),
                recipeIngredientDto.getAmount(),
                recipeIngredientDto.getMeasurement(),
                toRecipe(recipeIngredientDto.getRecipe()));
        /*List<RecipeIngredient> recipeIngredients = new ArrayList<>();
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
        RecipeInstruction recipeInstruction = new RecipeInstruction(recipeIngredientDto.getRecipe().getInstructions());
        Recipe recipe = new Recipe(recipeIngredientDto.getRecipe().getRecipeName(), recipeIngredients, recipeInstruction, recipeCategories);
        Ingredient ingredient = new Ingredient(recipeIngredientDto.getIngredient());
        return new RecipeIngredient(0, ingredient, recipeIngredientDto.getAmount(),
                recipeIngredientDto.getMeasurement(), recipe);*/
    }

    public RecipeIngredientDto toRecipeIngredientDto(RecipeIngredient recipeIngredient) {
        return new RecipeIngredientDto(recipeIngredient.getRecipeIngredientId(), toIngredientDto(recipeIngredient.getIngredient()), recipeIngredient.getAmount(), recipeIngredient.getMeasurement());
    }


    //RECIPE INSTRUCTION CONVERTER
    public RecipeInstruction toRecipeInstruction(RecipeInstructionDto recipeInstructionDto) {
        return new RecipeInstruction(0, recipeInstructionDto.getRecipeInstructions());
    }

    public RecipeInstructionDto toRecipeInstructionDto(RecipeInstruction recipeInstruction) {
        return new RecipeInstructionDto(recipeInstruction.getRecipeInstructionId(), recipeInstruction.getRecipeInstructions());
    }


    //RECIPE CONVERTER
    public Recipe toRecipe(RecipeDto recipeDto) {
        RecipeInstruction instruction = new RecipeInstruction(0, recipeDto.getInstructions().getRecipeInstructions());
        Set<RecipeCategory> categories = new HashSet<>();
        for (RecipeCategoryDto categoryDto : recipeDto.getCategories()) {
            RecipeCategory recipeCategory = toRecipeCategory(categoryDto);
            categories.add(recipeCategory);
        }
        List<RecipeIngredient> recipeIngredientList = new ArrayList<>();
        for (RecipeIngredientDto ri : recipeDto.getIngredients()) {
            RecipeIngredient recipeIngredient = toRecipeIngredient(ri);
        }
        Recipe recipe = new Recipe(0, recipeDto.getRecipeName(), recipeIngredientList, instruction, categories);
        return recipe;
    }

    public RecipeDto toRecipeDto(Recipe recipe) {
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
