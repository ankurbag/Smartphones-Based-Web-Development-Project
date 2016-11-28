package com.neu.mealpass.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.neu.mealpass.user.preference.Ingredients;
import com.neu.mealpass.user.preference.MealPortion;
import com.neu.mealpass.user.preference.MealTypeEnum;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PreferenceRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6822947642627063837L;
	
	private List<Ingredients> ingredients;
	private MealPortion mealPortion;
	private List<MealTypeEnum> mealType;
	
	public PreferenceRequest(){
		
	}
	
	public List<Ingredients> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}
	public MealPortion getMealPortion() {
		return mealPortion;
	}
	public void setMealPortion(MealPortion mealPortion) {
		this.mealPortion = mealPortion;
	}
	public List<MealTypeEnum> getMealType() {
		return mealType;
	}
	public void setMealType(List<MealTypeEnum> mealType) {
		this.mealType = mealType;
	}
}
