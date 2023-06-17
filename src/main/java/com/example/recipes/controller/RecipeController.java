package com.example.recipes.controller;

import com.example.recipes.models.Recipe;
import com.example.recipes.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
}
