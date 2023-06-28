package com.example.recipes.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RecipeDTO {
    @NotEmpty(message = "The name field is required")
    private String name;
    @NotEmpty(message = "The ingredients field is required")
    private String ingredients;
    @NotEmpty(message = "The preparation field is required")
    private String preparation;
}
