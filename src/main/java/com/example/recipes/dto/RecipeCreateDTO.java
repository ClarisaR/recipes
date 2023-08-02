package com.example.recipes.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeCreateDTO {
    @NotNull(message = "The field name is required")
    @Size(min=2, max=20, message = "The field must contain at least two characters")
    private String name;
    @NotNull(message = "The field ingredients is required")
    @Size(min=4, max=100, message = "The field must contain between four and one hundred characters")
    private String ingredients;
    @NotNull(message = "The field preparation is required")
    @Size(min=5, max=200, message = "The field must contain between five and two hundred characters")
    private String preparation;

}
