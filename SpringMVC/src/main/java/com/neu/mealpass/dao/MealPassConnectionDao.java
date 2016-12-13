package com.neu.mealpass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.metal.MetalProgressBarUI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neu.mealpass.meal.Meal;
import com.neu.mealpass.meal.MealPass;
import com.neu.mealpass.meal.MealPassOption;
import com.neu.mealpass.meal.Restaurant;
import com.neu.mealpass.meal.RestaurantMeal;
import com.neu.mealpass.user.Address;
import com.neu.mealpass.user.preference.Ingredients;
import com.neu.mealpass.user.preference.MealPortion;
import com.neu.mealpass.user.preference.MealPreference;
import com.neu.mealpass.user.preference.MealTypeEnum;
import com.neu.mealpass.user.preference.UserPreference;

public class MealPassConnectionDao {

	private static final Logger logger = LoggerFactory.getLogger(MealPassConnectionDao.class);
	private static final String TAG = "MealPassConnectionDao ";
	
	/**
	 * Gets the List of MealPass
	 * @param conn
	 * @return
	 */
	public static List<MealPassOption> getMealPassOptions(Connection conn) {
		System.out.println("getMealPassOptions");
		logger.info("getMealPassOptions");
		List<MealPassOption> mealPassOptions = new ArrayList<MealPassOption>();
		String query = "Select * from " + DbConstants.Tables.TABLE_MEALPASS_OPTION;

		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					MealPassOption mealPassOption = new MealPassOption();
					mealPassOption.setMealPassId(rs.getInt(DbConstants.Columns.MEALPASS_ID));
					mealPassOption.setMealPassName(rs.getString(DbConstants.Columns.MEALPASS_NAME));
					mealPassOption.setMealPassDescription(rs.getString(DbConstants.Columns.MEALPASS_DESCRIPTION));
					mealPassOption.setMealPassDurationText(rs.getString(DbConstants.Columns.MEALPASS_DURATION_TEXT));
					mealPassOption.setDurationInMinutes(rs.getString(DbConstants.Columns.DURATION_IN_MINUTES));
					mealPassOption.setImageUrl(rs.getString(DbConstants.Columns.IMAGE_URL));
					mealPassOption.setTotalMeals(rs.getInt(DbConstants.Columns.TOTAL_MEALS));
					mealPassOptions.add(mealPassOption);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mealPassOptions;
	}
	/**
	 * Sets the Meal Preference
	 * @param conn
	 * @param userId
	 * @param mealPreference
	 * @return
	 */
	public static boolean setMealPreferences(Connection conn, int userId, MealPreference mealPreference) {
		if (mealPreference != null) {
			if (mealPreference != null) {
				String query = "INSERT INTO " + DbConstants.Tables.TABLE_MEAL_PREFERENCE + " ( "
						+ DbConstants.Columns.MEAL_TYPE + "," + DbConstants.Columns.MEAL_PORTION + ","
						+ DbConstants.Columns.USER_ID + " ) values(?,?,?)";
				String mealType = "";
				String mealPortion = mealPreference.getMealPortion().name();
				List<MealTypeEnum> mealTypeEnums = mealPreference.getMealTypes();
				if (mealTypeEnums != null) {
					for (int i = 0; i < mealTypeEnums.size(); i++) {
						if (i == 0) {
							mealType = mealTypeEnums.get(i).name();
						} else {
							mealType = mealType + "," + mealTypeEnums.get(i).name();
						}
					}
				}

				int row = -1;
				try {
					PreparedStatement pstmt = conn.prepareStatement(query);

					pstmt.setString(1, mealType);
					pstmt.setString(2, mealPortion);
					pstmt.setInt(3, userId);
					row = pstmt.executeUpdate();
					if (row > 0)
						return true;
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}

		return false;
	}
	/**
	 * Sets the Ingredients
	 * @param conn
	 * @param userId
	 * @param ingredients
	 * @return
	 */
	public static boolean setIngredients(Connection conn, int userId, List<Ingredients> ingredients) {

		if (ingredients != null) {
			for (int i = 0; i < ingredients.size(); i++) {
				Ingredients ingredients2 = ingredients.get(0);
				if (ingredients2 != null) {
					String query = "INSERT INTO " + DbConstants.Tables.TABLE_INGREDIENTS + " ( "
							+ DbConstants.Columns.INGREDIENTS_ENUM + "," + DbConstants.Columns.INGREDIENTS_LIKE + ","
							+ DbConstants.Columns.USER_ID + " ) values(?,?,?)";
					int row = -1;
					try {
						PreparedStatement pstmt = conn.prepareStatement(query);

						pstmt.setString(1, ingredients2.getIngredientsEnum().name());
						pstmt.setString(2, ingredients2.getIngredientsLike().name());
						pstmt.setInt(3, userId);
						row = pstmt.executeUpdate();
						if (row > 0)
							return true;
					} catch (SQLException e) {
						e.printStackTrace();

					}
				}
			}
		}

		return false;
	}
	/**
	 * Sets the User Preferences
	 * @param conn
	 * @param userId
	 * @param userPreference
	 * @return
	 */
	public static boolean setPreferences(Connection conn, int userId, UserPreference userPreference) {

		if (userPreference != null) {

			boolean mealPreferenceSet = setMealPreferences(conn, userId, userPreference.getMealPreference());
			System.out.println(TAG + " setPreferences mealPreferenceSet : " + mealPreferenceSet);
			boolean ingredientsPreferenceSet = setIngredients(conn, userId, userPreference.getIngredients());
			System.out.println(TAG + " setPreferences ingredientsPreferenceSet : " + ingredientsPreferenceSet);
			if (mealPreferenceSet || ingredientsPreferenceSet) {

				return true;
			}

		}

		return false;
	}
	/**
	 * Get list based on user preference like meal type, meal portion,ingredients like dislike
	 * @param conn
	 * @param userId
	 * @return
	 */
	public static List<RestaurantMeal> getTodaysRestaurantMeal(Connection conn, int userId) {
		
		logger.info("getTodaysRestaurantMeal");
		List<RestaurantMeal> todaysRestaurantMeals = new ArrayList<RestaurantMeal>();
		List<MealPassOption> mealPassOptions = getMealPassOptions(conn);
		String query = "Select * from " + DbConstants.Tables.TABLE_RESTAURANTS_MEAL;

		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					RestaurantMeal restaurantMeal = new RestaurantMeal();
					restaurantMeal.setMeal(getMeal(conn,rs.getInt(DbConstants.Columns.ID_MEAL)));
					restaurantMeal.setRestaurant(getRestaurant(conn, rs.getInt(DbConstants.Columns.ID_RESTAURANTS)));
					todaysRestaurantMeals.add(restaurantMeal);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return todaysRestaurantMeals;
	}
	/**
	 * Returns Meal on passing MealId
	 * @param conn
	 * @param mealId
	 * @return
	 */
	public static Meal getMeal(Connection conn, int mealId){
		Meal meal = null;
		String query = "Select * from " + DbConstants.Tables.TABLE_MEAL + " where "+ DbConstants.Columns.ID_MEAL +"="+mealId;

		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					meal = new Meal();
					meal.setId(mealId);
					meal.setMealName(rs.getString(DbConstants.Columns.MEAL_NAME));
					meal.setMealPortion(MealPortion.valueOf(rs.getString(DbConstants.Columns.MEAL_PORTION)));
					meal.setMealTypeEnum(MealTypeEnum.valueOf(rs.getString(DbConstants.Columns.MEAL_TYPE_ENUM)));
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return meal;
	}
	/**
	 * Gets Restaurant from the restaurant Id
	 * @param conn
	 * @param restaurantId
	 * @return
	 */
	public static Restaurant getRestaurant(Connection conn, int restaurantId){
		Restaurant restaurant = null;
		String query = "Select * from " + DbConstants.Tables.TABLE_RESTAURANTS + " where "+ DbConstants.Columns.ID_RESTAURANTS +"="+restaurantId;

		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					restaurant = new Restaurant();
					restaurant.setId(restaurantId);
					restaurant.setRestaurantName(rs.getString(DbConstants.Columns.NAME_RESTAURANT));
					restaurant.setAddress(getAddress(conn, rs.getInt(DbConstants.Columns.ADDRESSID)) );
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurant;
	}
	/**
	 * Gets Address from the Address Id
	 * @param conn
	 * @param addressId
	 * @return
	 */
	public static Address getAddress(Connection conn, int addressId){
		Address address = null;
		String query = "Select * from " + DbConstants.Tables.TABLE_ADDRESS + " where "+ DbConstants.Columns.ADDRESSID +"="+addressId;

		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					address = new Address();
					address.setAddressid(addressId);
					address.setAddress1(rs.getString(DbConstants.Columns.ADDRESS1));
					address.setAddress2(rs.getString(DbConstants.Columns.ADDRESS2));
					address.setCity(rs.getString(DbConstants.Columns.CITY));
					address.setState(rs.getString(DbConstants.Columns.STATE));
					address.setCountry(rs.getString(DbConstants.Columns.COUNTRY));
					address.setZipCode(rs.getString(DbConstants.Columns.ZIP));
					address.setLattitude(rs.getLong(DbConstants.Columns.LATITUDE));
					address.setLongitude(rs.getLong(DbConstants.Columns.LONGITUDE));
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}
	/**
	 * 
	 * @param conn
	 * @param mealId
	 * @param userId
	 * @return
	 */
	public static MealPass orderMeal(Connection conn, String mealId, int userId) {

		// check remaining meal, enter into order table, subtract meal from
		// restaurant meal count, and subtract user meal remaining

		// populate mealPass and return
		// MealPass mealPass = new MealPass();

		return null;
	}
	/**
	 * 
	 * @param conn
	 * @param mealId
	 * @param userId
	 * @return
	 */
	public static MealPass deleteMeal(Connection conn, String mealId, int userId) {

		// delete from order table, increment meal from restaurant meal count,
		// and increment user meal remaining

		// populate mealPass and return
		// MealPass mealPass = new MealPass();

		return null;
	}
}
