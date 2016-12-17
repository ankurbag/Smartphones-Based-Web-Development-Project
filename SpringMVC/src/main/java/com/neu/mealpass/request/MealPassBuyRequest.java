package com.neu.mealpass.request;

import com.neu.mealpass.meal.MealPassOption;

public class MealPassBuyRequest extends Request {
	
	private MealPassOption mealPassOption;

	public MealPassOption getMealPassOption() {
		return mealPassOption;
	}

	public void setMealPassOption(MealPassOption mealPassOption) {
		this.mealPassOption = mealPassOption;
	}

}
