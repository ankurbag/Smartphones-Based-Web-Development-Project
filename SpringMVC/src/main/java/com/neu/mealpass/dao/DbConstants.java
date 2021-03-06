package com.neu.mealpass.dao;

public class DbConstants {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://aasqt87uhdjiu9.cpokblqfh08u.us-west-2.rds.amazonaws.com:3306/mealpaldb";
	static final String USER = "root";
	static final String PASSWORD = "root1234";

	public class Tables {
		public static final String TABLE_ACCOUNT = "mealpaldb.account";
		public static final String TABLE_ADDRESS = "mealpaldb.address";
		public static final String TABLE_INGREDIENTS = "mealpaldb.ingredients";
		public static final String TABLE_MEAL = "mealpaldb.Meal";
		public static final String TABLE_MEAL_INGREDIENTS = "mealpaldb.Meal_Ingredients";
		public static final String TABLE_MEALPASS_OPTION = "mealpaldb.mealPassOptions";
		public static final String TABLE_MEAL_PREFERENCE = "mealpaldb.MealPreference";
		public static final String TABLE_RESTAURANTS = "mealpaldb.Restaurants";
		public static final String TABLE_RESTAURANTS_INGREDIENTS = "mealpaldb.Restaurants_Ingredients";
		public static final String TABLE_RESTAURANTS_MEAL = "mealpaldb.RestaurantsMeal";
		public static final String TABLE_USER = "mealpaldb.user";
		public static final String TABLE_MEALPASS = "mealpaldb.MealPass";
	}

	public class Columns {

		// ACCOUNT
		public static final String USER_ID = "user_id";
		public static final String USERNAME = "Username";
		public static final String PASSWORD = "Password";
		public static final String TOKEN = "token";

		// ADDRESS
		public static final String ADDRESSID = "addressid";
		public static final String ADDRESS1 = "address1";
		public static final String ADDRESS2 = "address2";
		public static final String CITY = "city";
		public static final String STATE = "state";
		public static final String ZIP = "zip";
		public static final String COUNTRY = "country";
		public static final String LATITUDE = "latitude";
		public static final String LONGITUDE = "longitude";

		// INGREDIENTS
		public static final String INGREDIENTS_ID = "ingredientsid";
		public static final String INGREDIENTS_ENUM = "ingredients_enum";
		public static final String INGREDIENTS_LIKE = "ingredients_like";

		// MEAL
		public static final String ID_MEAL = "idMeal";
		public static final String MEAL_NAME = "mealName";
		public static final String MEAL_TYPE_ENUM = "mealTypeEnum";
		public static final String MEALPORTION = "mealPortion";

		// MEALPASSOPTIONS
		public static final String MEALPASS_ID = "mealPassId";
		public static final String MEALPASS_NAME = "mealPassName";
		public static final String MEALPASS_DURATION_TEXT = "mealPassDurationText";
		public static final String DURATION_IN_MINUTES = "durationInMinutes";
		public static final String MEALPASS_DESCRIPTION = "mealPassDescription";
		public static final String IMAGE_URL = "imageUrl";
		public static final String TOTAL_MEALS = "totalMeals";

		// MEALPREFERENCE
		public static final String MEAL_PREFERENCE_ID = "mealpreferenceid";
		public static final String MEAL_TYPE = "meal_type";
		public static final String MEAL_PORTION = "meal_portion";
		
		// RESTAURANTS
		public static final String ID_RESTAURANTS = "idRestaurants";
		public static final String NAME_RESTAURANT = "name";
		public static final String RATING = "Rating";
		

		// USER
		public static final String FIRST_NAME = "first_name";
		public static final String LAST_NAME = "last_name";
		public static final String PHONE_NUM = "phone_num";
		public static final String EMAIL_ADDRESS = "email_address";
		public static final String USERTABLE_USERNAME = "username";
		
		// RESTAURANTSMEAL
		public static final String USER_NAME = "userName";
		public static final String ORDER_DATE  = "orderDate";
		

		// MEALPASS
		public static final String MEAL_USED  = "mealUsed";
		public static final String PLAN_NAME  = "planName";
		public static final String MEAL_CYCLE_END_DATE  = "mealCycleEndDate";
		public static final String MEAL_CYCLE_START_DATE  = "mealCycleStartDate";
		public static final String MEAL_TOTAL  = "mealTotal";
		
	}

}
