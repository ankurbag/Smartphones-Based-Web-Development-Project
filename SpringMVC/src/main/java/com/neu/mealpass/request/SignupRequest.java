package com.neu.mealpass.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.neu.mealpass.user.preference.Ingredients;
import com.neu.mealpass.user.preference.MealPortion;
import com.neu.mealpass.user.preference.MealTypeEnum;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SignupRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6822947642627063837L;
	
	public SignupRequest(){
		
	}
	
	
}
