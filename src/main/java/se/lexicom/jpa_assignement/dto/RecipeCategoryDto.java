package se.lexicom.jpa_assignement.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

public class RecipeCategoryDto {

    private int recipeCategoryId;
    private String category;


    public RecipeCategoryDto() {
    }

    public RecipeCategoryDto(int recipeCategoryId, String category) {
        this.recipeCategoryId = recipeCategoryId;
        this.category = category;
    }

    public RecipeCategoryDto(String category) {
        this.category = category;
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

    @Override
    public String toString() {
        return "RecipeCategoryDto{" +
                "recipeCategoryId=" + recipeCategoryId +
                ", category='" + category + '\'' +
                '}';
    }
}
