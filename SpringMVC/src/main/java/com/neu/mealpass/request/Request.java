package com.neu.mealpass.request;

import java.io.Serializable;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.neu.mealpass.user.Account;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2003939474974837256L;
	
	private Account account;
	private HashMap<String, String> opaqueData;
	
	public Request(){
		
	}
	
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
