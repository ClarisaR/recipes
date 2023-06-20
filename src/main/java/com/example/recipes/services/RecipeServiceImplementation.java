package com.example.recipes.services;

import com.example.recipes.dto.RecipeDTO;
import com.example.recipes.models.Recipe;
import com.example.recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class RecipeServiceImplementation implements RecipeService {
    @Autowired
    RecipeRepository recipeRepository;
    @Override
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public void createRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = Recipe.builder()
                .date(new Date())
                .name(recipeDTO.getName())
                .ingredients(recipeDTO.getIngredients())
                .preparation(recipeDTO.getPreparation())
                .build();
        recipeRepository.save(recipe);
    }

}
