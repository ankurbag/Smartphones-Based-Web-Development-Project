package com.neu.mealpass.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.neu.mealpass.user.User;
import com.neu.mealpass.user.preference.UserPreference;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PreferenceRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6822947642627063837L;
	
	private UserPreference userPreference;
	private User user;
	
	public PreferenceRequest(){
		
	}

	public UserPreference getUserPreference() {
		return userPreference;
	}

	public void setUserPreference(UserPreference userPreference) {
		this.userPreference = userPreference;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
