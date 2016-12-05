package com.neu.mealpass.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neu.mealpass.meal.MealPassOption;
import com.neu.mealpass.meal.RestaurantMeal;
import com.neu.mealpass.user.preference.Ingredients;
import com.neu.mealpass.user.preference.MealPreference;
import com.neu.mealpass.user.preference.MealTypeEnum;
import com.neu.mealpass.user.preference.UserPreference;

public class MealPassConnectionDao {

	private static final Logger logger = LoggerFactory.getLogger(MealPassConnectionDao.class);
	private static final String TAG = "MealPassConnectionDao ";
	
	public static List<MealPassOption> getMealPassOptions(Connection conn) {
		System.out.println("getMealPassOptions");
		List<MealPassOption> mealPassOptions = new ArrayList<MealPassOption>();
		String query = "Select * from "+DbConstants.Tables.TABLE_MEALPASS_OPTION;

		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs != null) {
				while(rs.next()){
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
	
	public static boolean setMealPreferences(Connection conn, int userId, MealPreference mealPreference){
		if(mealPreference != null){
			if(mealPreference != null){
				String query = "INSERT INTO "+DbConstants.Tables.TABLE_USER_MEAL_PREFERENCE+
				" ( "+DbConstants.Columns.MEAL_TYPE+","+DbConstants.Columns.MEAL_PORTION +","+DbConstants.Columns.USER_ID+" ) values(?,?,?)";
				String mealType = "";
				String mealPortion = mealPreference.getMealPortion().name();
				List<MealTypeEnum> mealTypeEnums = mealPreference.getMealTypes();
				if(mealTypeEnums != null){
					for(int i=0; i < mealTypeEnums.size() ; i++){
						if(i == 0){
							mealType = mealTypeEnums.get(i).name();
						}else{
							mealType = mealType+","+ mealTypeEnums.get(i).name();
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
					if(row > 0) return true;
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
		
		return false;
	}
	
	public static boolean setIngredients(Connection conn, int userId, List<Ingredients> ingredients){
		
		if(ingredients != null){
			for(int i=0; i< ingredients.size(); i++){
				Ingredients ingredients2 = ingredients.get(0);
				if(ingredients2 != null){
					String query = "INSERT INTO "+DbConstants.Tables.TABLE_USER_PREFERENCE_INGREDIENTS+
							" ( "+DbConstants.Columns.INGREDIENTS_ENUM+","+DbConstants.Columns.INGREDIENTS_LIKE +","+DbConstants.Columns.USER_ID+" ) values(?,?,?)";
					int row = -1;
					try {
						PreparedStatement pstmt = conn.prepareStatement(query);

						pstmt.setString(1, ingredients2.getIngredientsEnum().name());
						pstmt.setString(2, ingredients2.getIngredientsLike().name());
						pstmt.setInt(3, userId);
						row = pstmt.executeUpdate();
						if(row > 0) return true;
					} catch (SQLException e) {
						e.printStackTrace();

					}
				}
			}
		}
		
		return false;
	}
	
	public static boolean setPreferences(Connection conn, int userId, UserPreference userPreference){
		
		if(userPreference != null){
			
			boolean mealPreferenceSet = setMealPreferences(conn, userId, userPreference.getMealPreference());
			System.out.println(TAG+" setPreferences mealPreferenceSet : "+mealPreferenceSet);
			boolean ingredientsPreferenceSet = setIngredients(conn, userId, userPreference.getIngredients());
			System.out.println(TAG+" setPreferences ingredientsPreferenceSet : "+ingredientsPreferenceSet);
			if(mealPreferenceSet || ingredientsPreferenceSet){
				
				return true;
			}
			
		}
		
		return false;
	}
	
	public static List<RestaurantMeal> getTodaysRestaurantMeal(Connection conn, int userId){
		// get list based on user preference like meal type, meal portion, ingredients like dislike
		return null;
	}
}
