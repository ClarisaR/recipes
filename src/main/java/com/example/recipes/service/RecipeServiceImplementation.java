package com.example.recipes.service;

import com.example.recipes.dto.RecipeCreateDTO;
import com.example.recipes.dto.RecipeUpdateDTO;
import com.example.recipes.model.Recipe;
import com.example.recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImplementation implements RecipeService {
    @Autowired
    RecipeRepository recipeRepository;
    @Override
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public void createRecipe(RecipeCreateDTO recipeDTO) {
        Recipe recipe = Recipe.builder()
                .date(new Date())
                .name(recipeDTO.getName())
                .ingredients(recipeDTO.getIngredients())
                .preparation(recipeDTO.getPreparation())
                .build();
        recipeRepository.save(recipe);
    }

    @Override
    public Optional<Recipe> getRecipe(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public void updateRecipe(Long id, RecipeUpdateDTO recipeUpdateDTO, Recipe recipe) {
        Recipe r = Recipe.builder()
                .date(recipe.getDate())
                .id(recipe.getId())
                .name(recipeUpdateDTO.getName())
                .ingredients(recipeUpdateDTO.getIngredients())
                .preparation(recipeUpdateDTO.getPreparation())
                .build();
        recipeRepository.save(r);
    }

    @Override
    public void deleteRecipe(Recipe recipe) {
        recipeRepository.delete(recipe);
    }

    @Override
    public void deleteAllRecipes() {
        recipeRepository.deleteAll();
    }

}
