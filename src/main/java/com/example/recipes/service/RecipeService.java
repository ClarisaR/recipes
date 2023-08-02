package com.example.recipes.service;

import com.example.recipes.dto.RecipeCreateDTO;
import com.example.recipes.dto.RecipeUpdateDTO;
import com.example.recipes.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RecipeService {
    List<Recipe> getRecipes();

    void createRecipe(RecipeCreateDTO recipeDTO);

    Optional<Recipe> getRecipe(Long id);

    void updateRecipe(Long id, RecipeUpdateDTO recipeUpdateDTO, Recipe recipe);

    void deleteRecipe(Recipe recipe);

    void deleteAllRecipes();
}
