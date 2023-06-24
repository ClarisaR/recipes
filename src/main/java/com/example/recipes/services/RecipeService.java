package com.example.recipes.services;

import com.example.recipes.dto.RecipeDTO;
import com.example.recipes.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RecipeService {
    List<Recipe> getRecipes();

    void createRecipe(RecipeDTO recipeDTO);

    Optional<Recipe> getRecipe(Long id);

    void updateRecipe(Long id, RecipeDTO recipeDTO, Recipe recipe);

    void deleteRecipe(Recipe recipe);

    void deleteAllRecipes();
}
