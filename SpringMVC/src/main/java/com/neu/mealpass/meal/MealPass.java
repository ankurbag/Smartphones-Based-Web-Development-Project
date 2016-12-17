package com.neu.mealpass.meal;

import com.neu.mealpass.user.User;

public class MealPass {

	private int id;
	private String planName;
	private String startDate;
	private String endDate;
	private int mealTotal;
	private int mealUsed;
	private User user;
	private boolean active;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getMealTotal() {
		return mealTotal;
	}
	public void setMealTotal(int mealTotal) {
		this.mealTotal = mealTotal;
	}
	public int getMealUsed() {
		return mealUsed;
	}
	public void setMealUsed(int mealUsed) {
		this.mealUsed = mealUsed;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
