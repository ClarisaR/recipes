package com.example.recipes.controller;

import com.example.recipes.dto.RecipeDTO;
import com.example.recipes.models.Recipe;
import com.example.recipes.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class RecipeController {
    @Autowired
    RecipeService recipeService;
    @GetMapping("/recipes")
    public String getRecipes(Model model){
        List<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }
    @GetMapping("/recipes/new")
    public String getFormToCreateRecipe(Model model){
        model.addAttribute("recipe", new RecipeDTO());
        return "formNewRecipe";
    }
    @PostMapping("/recipes")
    public String createRecipe(RecipeDTO recipeDTO, Model model){
        recipeService.createRecipe(recipeDTO);
        List<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }
    @GetMapping("/recipes/{id}")
    public String getRecipe(@PathVariable Long id, Model model){
        Optional<Recipe> optionalRecipe = recipeService.getRecipe(id);
        if(optionalRecipe.isEmpty()){
            return "recipeNotFound";
        }
        model.addAttribute("recipe", optionalRecipe.get());
        return "recipe";
    }
    @PostMapping("/recipes/{id}")
    public String updateRecipe(@PathVariable("id")Long id, Model model, RecipeDTO recipeDTO){
        Optional<Recipe> optionalRecipe = recipeService.getRecipe(id);
        if(optionalRecipe.isEmpty()){
            return "recipeNotFound";
        }
        model.addAttribute("recipe", optionalRecipe.get());
        recipeService.updateRecipe(id, recipeDTO, optionalRecipe.get());
        List<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }
    @PostMapping("/recipes/delete/{id}")
    public String deleteRecipe(@PathVariable("id")Long id, Model model){
        Optional<Recipe> optionalRecipe =recipeService.getRecipe(id);
        if(optionalRecipe.isEmpty()){
            return "recipeNotExists";
        }
        recipeService.deleteRecipe(optionalRecipe.get());
        List<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }
    @PostMapping("/recipes/delete/all")
    public String deleteAllRecipes(Model model){
        recipeService.deleteAllRecipes();
        List<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }
}
