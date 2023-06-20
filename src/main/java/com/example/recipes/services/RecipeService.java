package com.example.recipes.services;

import com.example.recipes.dto.RecipeDTO;
import com.example.recipes.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecipeService {
    List<Recipe> getRecipes();

    void createRecipe(RecipeDTO recipeDTO);
}
