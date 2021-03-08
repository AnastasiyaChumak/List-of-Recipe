package com.example.service;

import java.util.List;

import com.example.entity.Recipe;

public interface RecipeService {
	
	public List<Recipe> findAll();
	
	public Recipe createRecipe(Recipe recipe);
	
	public List<Recipe> findByName(String name);

}
