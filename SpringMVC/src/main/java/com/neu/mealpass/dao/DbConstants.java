package com.neu.mealpass.dao;

public class DbConstants {

	public class Tables{
		public static final String TABLE_MEALPASS_OPTION = "mealpaldb.mealPassOptions";
		public static final String TABLE_USER_MEAL_PREFERENCE = "mealpaldb.MealPreference";
		public static final String TABLE_USER_PREFERENCE_INGREDIENTS = "mealpaldb.ingredients";
	}
	public class Columns{
		
		public static final String USER_ID = "user_id";
		public static final String USERNAME = "Username";
		public static final String PASSWORD = "Password";
		public static final String TOKEN = "token";
		
		public static final String MEALPASS_ID = "mealPassId";
		public static final String MEALPASS_NAME = "mealPassName";
		public static final String MEALPASS_DURATION_TEXT = "mealPassDurationText";
		public static final String DURATION_IN_MINUTES = "durationInMinutes";
		public static final String MEALPASS_DESCRIPTION = "mealPassDescription";
		public static final String IMAGE_URL = "imageUrl";
		public static final String TOTAL_MEALS = "totalMeals";
		
		public static final String INGREDIENTS_ID = "ingredientsid";
		public static final String INGREDIENTS_ENUM = "ingredients_enum";
		public static final String INGREDIENTS_LIKE = "ingredients_like";
		
		public static final String MEAL_PREFERENCE_ID = "mealpreferenceid";
		public static final String MEAL_TYPE = "meal_type";
		public static final String MEAL_PORTION = "meal_portion";
		
	}
	
}
