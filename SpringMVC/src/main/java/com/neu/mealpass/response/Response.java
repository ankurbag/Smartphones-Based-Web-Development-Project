package com.neu.mealpass.response;

import java.util.HashMap;
import java.util.List;

import com.neu.mealpass.meal.MealPassOption;
import com.neu.mealpass.meal.RestaurantMeal;
import com.neu.mealpass.user.Account;

public class Response {

	private StatusCode statusCode;
	private String statusUserMessage;
	private Account account;
	private HashMap<String, String> opaqueData;
	private List<MealPassOption> mealPassOptions;
	private List<RestaurantMeal> restaurantMeal;

	
	public StatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusUserMessage() {
		return statusUserMessage;
	}

	public void setStatusUserMessage(String statusUserMessage) {
		this.statusUserMessage = statusUserMessage;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public List<MealPassOption> getMealPassOptions() {
		return mealPassOptions;
	}

	public void setMealPassOptions(List<MealPassOption> mealPassOptions) {
		this.mealPassOptions = mealPassOptions;
	}
	
	public HashMap<String, String> getOpaqueData() {
		return opaqueData;
	}
	public void setOpaqueData(HashMap<String, String> opaqueData) {
		this.opaqueData = opaqueData;
	}
	
	public List<RestaurantMeal> getRestaurantMeal() {
		return restaurantMeal;
	}

	public void setRestaurantMeal(List<RestaurantMeal> restaurantMeal) {
		this.restaurantMeal = restaurantMeal;
	}

	public static boolean isStatusOk(StatusCode statusCode){
		if(statusCode == StatusCode.STATUS_OK){
			return true;
		}
		
		return false;
	}
	
}
