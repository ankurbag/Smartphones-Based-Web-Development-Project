package com.neu.mealpass.user;

import com.neu.mealpass.meal.MealPass;
import com.neu.mealpass.user.preference.UserPreference;

public class User {
	
	private int id;
	private String username;
	private String name;
	private String phoneNum;
	private String emailAddress;
	private Address address;
	private UserPreference userPreference;
	private Account account;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public UserPreference getUserPreference() {
		return userPreference;
	}
	public void setUserPreference(UserPreference userPreference) {
		this.userPreference = userPreference;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
