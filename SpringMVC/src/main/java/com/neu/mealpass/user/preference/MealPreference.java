package com.neu.mealpass.user.preference;

import java.util.List;

public class MealPreference {

	private int id;
	private List<MealTypeEnum> mealTypes;
	private MealPortion mealPortion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<MealTypeEnum> getMealTypes() {
		return mealTypes;
	}
	public void setMealTypes(List<MealTypeEnum> mealTypes) {
		this.mealTypes = mealTypes;
	}
	public MealPortion getMealPortion() {
		return mealPortion;
	}
	public void setMealPortion(MealPortion mealPortion) {
		this.mealPortion = mealPortion;
	}
	
	
}
