package com.neu.mealpass.response;

import java.util.HashMap;
import java.util.List;

import com.neu.mealpass.meal.MealPass;
import com.neu.mealpass.meal.MealPassOption;
import com.neu.mealpass.meal.RestaurantMeal;
import com.neu.mealpass.user.Account;
import com.neu.mealpass.user.User;

public class Response {

	private StatusCode statusCode;
	private String statusUserMessage;
	private Account account;
	private User user;
	private HashMap<String, String> opaqueData;
	private List<MealPassOption> mealPassOptions;
	private List<RestaurantMeal> restaurantMeal;
	private MealPass mealPass;
	private RestaurantMeal userRestaurantMeal;
	private boolean mealOrdered;
	
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

	public MealPass getMealPass() {
		return mealPass;
	}

	public void setMealPass(MealPass mealPass) {
		this.mealPass = mealPass;
	}

	public RestaurantMeal getUserRestaurantMeal() {
		return userRestaurantMeal;
	}

	public void setUserRestaurantMeal(RestaurantMeal userRestaurantMeal) {
		this.userRestaurantMeal = userRestaurantMeal;
	}

	public boolean isMealOrdered() {
		return mealOrdered;
	}

	public void setMealOrdered(boolean mealOrdered) {
		this.mealOrdered = mealOrdered;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
