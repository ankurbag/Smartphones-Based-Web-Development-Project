package com.neu.mealpass.meal;

import java.sql.Date;

public class RestaurantMeal {

	private Restaurant restaurant;
	private Meal meal;
	private int totalMeals;
	private Date orderDate;
	
	
	
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalMeals() {
		return totalMeals;
	}
	public void setTotalMeals(int totalMeals) {
		this.totalMeals = totalMeals;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Meal getMeal() {
		return meal;
	}
	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	
}
