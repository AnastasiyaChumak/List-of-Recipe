package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DTO.RecipeDto;
import com.example.entity.Recipe;
import com.example.service.RecipeService;

@Controller
public class MainController { 

	@Autowired
	private RecipeService service;

	@GetMapping("/")
	public String searchRecipe(Model model, @RequestParam(defaultValue = "") String name) {
		model.addAttribute("recipes", service.findByName(name));
		return "views/index";
	}

	@GetMapping("/addRecipe")
	public String showAddBookPage(Model model) {
		model.addAttribute("recipe", new RecipeDto());
		return "views/addRecipe";
	}

	@PostMapping("/addRecipe")
	public String addBookPage(@Valid RecipeDto recipe, BindingResult bindingResult, Model model) {
		Recipe newRecipe = new Recipe();
		newRecipe.setName(recipe.getName());
		newRecipe.setText(recipe.getText());
		if (recipe.getName().equals("") || recipe.getText().equals("")) {
			return "views/empty";
		} else {
			service.createRecipe(newRecipe);
			return "views/success";
		}
	}
	
}
