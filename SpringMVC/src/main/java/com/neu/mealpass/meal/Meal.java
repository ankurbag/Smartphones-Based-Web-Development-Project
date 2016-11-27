package com.neu.mealpass.meal;

import java.util.List;

import com.neu.mealpass.user.preference.IngredientsEnum;
import com.neu.mealpass.user.preference.MealPortion;
import com.neu.mealpass.user.preference.MealTypeEnum;

public class Meal {

	private int id;
	private String mealName;
	private MealTypeEnum mealTypeEnum;
	private MealPortion mealPortion;
	private List<IngredientsEnum> ingredients;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public MealTypeEnum getMealTypeEnum() {
		return mealTypeEnum;
	}
	public void setMealTypeEnum(MealTypeEnum mealTypeEnum) {
		this.mealTypeEnum = mealTypeEnum;
	}
	public MealPortion getMealPortion() {
		return mealPortion;
	}
	public void setMealPortion(MealPortion mealPortion) {
		this.mealPortion = mealPortion;
	}
	public List<IngredientsEnum> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<IngredientsEnum> ingredients) {
		this.ingredients = ingredients;
	}
	
}
