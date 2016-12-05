package com.neu.mealpass.meal;

public class MealPassOption {

	private int mealPassId;
	private String mealPassName;
	private String mealPassDurationText;
	private String durationInMinutes;
	private String mealPassDescription;
	private String imageUrl;
	private int totalMeals;
	public int getMealPassId() {
		return mealPassId;
	}
	public void setMealPassId(int mealPassId) {
		this.mealPassId = mealPassId;
	}
	public String getMealPassName() {
		return mealPassName;
	}
	public void setMealPassName(String mealPassName) {
		this.mealPassName = mealPassName;
	}
	public String getMealPassDurationText() {
		return mealPassDurationText;
	}
	public void setMealPassDurationText(String mealPassDurationText) {
		this.mealPassDurationText = mealPassDurationText;
	}
	public String getDurationInMinutes() {
		return durationInMinutes;
	}
	public void setDurationInMinutes(String durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}
	public String getMealPassDescription() {
		return mealPassDescription;
	}
	public void setMealPassDescription(String mealPassDescription) {
		this.mealPassDescription = mealPassDescription;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getTotalMeals() {
		return totalMeals;
	}
	public void setTotalMeals(int totalMeals) {
		this.totalMeals = totalMeals;
	}
	
}
