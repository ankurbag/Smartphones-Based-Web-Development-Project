package com.neu.mealpass.request;

import java.util.HashMap;

import com.neu.mealpass.user.Account;

public class Request {

	private Account account;
	private HashMap<String, String> opaqueData;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public HashMap<String, String> getOpaqueData() {
		return opaqueData;
	}
	public void setOpaqueData(HashMap<String, String> opaqueData) {
		this.opaqueData = opaqueData;
	}
	
	
}
