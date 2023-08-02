package com.example.recipes.controller;

import com.example.recipes.dto.RecipeCreateDTO;
import com.example.recipes.dto.RecipeUpdateDTO;
import com.example.recipes.model.Recipe;
import com.example.recipes.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        model.addAttribute("recipeDTO", new RecipeCreateDTO());
        return "formNewRecipe";
    }
    @PostMapping("/recipes")
    public String createRecipe(@Valid RecipeCreateDTO recipeDTO, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "formNewRecipe";
        }
        recipeService.createRecipe(recipeDTO);
        List<com.example.recipes.model.Recipe> recipes = recipeService.getRecipes();
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
    public String updateRecipe(@PathVariable("id")Long id, @Valid @ModelAttribute("recipe") RecipeUpdateDTO recipeUpdateDTO, BindingResult bindingResult, Model model){
        Optional<Recipe> optionalRecipe = recipeService.getRecipe(id);
        if(optionalRecipe.isEmpty()){
            return "recipeNotFound";
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("recipe", recipeUpdateDTO);
            return "recipe";
        }

        recipeService.updateRecipe(id, recipeUpdateDTO, optionalRecipe.get());
        List<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }
    @PostMapping("/recipes/delete/{id}")
    public String deleteRecipe(@PathVariable("id")Long id, Model model){
        Optional<Recipe> optionalRecipe =recipeService.getRecipe(id);
        if(optionalRecipe.isEmpty()){
            return "recipeNotFound";
        }
        recipeService.deleteRecipe(optionalRecipe.get());
        List<com.example.recipes.model.Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }
    @PostMapping("/recipes/delete/all")
    public String deleteAllRecipes(Model model){
        recipeService.deleteAllRecipes();
        List<com.example.recipes.model.Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }
}
