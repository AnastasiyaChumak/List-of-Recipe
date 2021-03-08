package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Recipe;
import com.example.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	@Autowired
	private RecipeRepository repo;

	@Override
	public List<Recipe> findAll() {
		return repo.findAll();
	}
	
	@Override
	public Recipe createRecipe(Recipe recipe) {
		Recipe newRecipe = new Recipe();
		newRecipe.setName(recipe.getName());
		newRecipe.setText(recipe.getText());
		return repo.save(newRecipe);

	}

	@Override
	public List<Recipe> findByName(String name) {
		return repo.findByNameLike("%" + name + "%");
	}

}
