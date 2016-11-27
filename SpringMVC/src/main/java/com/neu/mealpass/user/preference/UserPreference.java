package com.neu.mealpass.user.preference;

import java.util.ArrayList;

public class UserPreference {

	private ArrayList<Ingredients> ingredients;
	private MealPreference mealPreference;
	public ArrayList<Ingredients> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}
	public MealPreference getMealPreference() {
		return mealPreference;
	}
	public void setMealPreference(MealPreference mealPreference) {
		this.mealPreference = mealPreference;
	}
	
}
