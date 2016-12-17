package com.neu.mealpass.request;

import com.neu.mealpass.meal.RestaurantMeal;

public class MealRequest extends Request{

	private RestaurantMeal restaurantMeal;

	public RestaurantMeal getRestaurantMeal() {
		return restaurantMeal;
	}

	public void setRestaurantMeal(RestaurantMeal restaurantMeal) {
		this.restaurantMeal = restaurantMeal;
	}

}
