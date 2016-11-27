package com.neu.mealpass.meal;

import com.neu.mealpass.user.User;

public class MealPass {

	private int id;
	private String planName;
	private long startDate;
	private long endDate;
	private int mealTotal;
	private int mealUsed;
	private User user;
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
	public long getStartDate() {
		return startDate;
	}
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}
	public long getEndDate() {
		return endDate;
	}
	public void setEndDate(long endDate) {
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
	
	
}
