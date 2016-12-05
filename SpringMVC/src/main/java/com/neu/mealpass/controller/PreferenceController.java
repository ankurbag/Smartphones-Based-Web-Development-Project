package com.neu.mealpass.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.neu.mealpass.dao.ConnectionDao;
import com.neu.mealpass.dao.MealPassConnectionDao;
import com.neu.mealpass.meal.MealPassOption;
import com.neu.mealpass.request.PreferenceRequest;
import com.neu.mealpass.request.Request;
import com.neu.mealpass.response.Response;
import com.neu.mealpass.response.StatusCode;
import com.neu.mealpass.user.Account;
import com.neu.mealpass.user.User;

@Controller
public class PreferenceController {

	private static final Logger logger = LoggerFactory.getLogger(PreferenceController.class);
	
	
	@RequestMapping(value = "/mealOption**", method = RequestMethod.POST)
	public void getMealPassOption(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody){
		System.out.println("getMealPassOption "+requestBody);
		StatusCode statusCode = StatusCode.STAUS_ERROR;
		Gson gson = new Gson();
	    if(requestBody !=  null){
	    	Request responseRequest = gson.fromJson(requestBody, Request.class);
	    	if(responseRequest != null){
	    		Account account = responseRequest.getAccount();
				if(account != null){
					System.out.println("getMealPassOption account "+account.getUserName() + " "+account.getPassword()+ " Token "+account.getToken());
					Connection connection = ConnectionDao.getConnection();
					if(ConnectionDao.isAccountValid(connection, account)){
						Response response2 = new Response(); 
						List<MealPassOption> mealPassOptions = MealPassConnectionDao.getMealPassOptions(connection);
						response2.setMealPassOptions(mealPassOptions);
						response2.setAccount(account);
						statusCode = StatusCode.STATUS_OK;
						response2.setStatusCode(StatusCode.STATUS_OK);
						String json = gson.toJson(response2);
						System.out.println("getMealPassOption Response : "+json);
						try {
							response.getWriter().write(json);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else{
						statusCode = StatusCode.ACCOUNT_INVALID;
					}
				}
	    	}
	    }
	    
	    if(!Response.isStatusOk(statusCode)){
			Response response2 = new Response(); 
			response2.setStatusCode(statusCode);
			response2.setStatusUserMessage("Error in getting meal pass options");
			String json = gson.toJson(response2);
			System.out.println("getMealPassOption Response : "+json);
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@RequestMapping(value = "/setpreference**", method = RequestMethod.POST)
	public void setPreference(HttpServletRequest request,HttpServletResponse response, @RequestBody String preferenceRequest){
		System.out.println("setPreference "+preferenceRequest);
		StatusCode statusCode = StatusCode.STAUS_ERROR;
		Gson gson = new Gson();
		if(preferenceRequest != null){
			PreferenceRequest preferenceRequest2 = gson.fromJson(preferenceRequest, PreferenceRequest.class);
			if(preferenceRequest2 != null){
				Account account = preferenceRequest2.getAccount();
				User user = preferenceRequest2.getUser();
				if(account != null && preferenceRequest2.getAccount() != null && user != null){
					Connection connection = ConnectionDao.getConnection();
					if(ConnectionDao.isAccountValid(connection, account)){
						boolean preferenceSaved = MealPassConnectionDao.setPreferences(connection, user.getId(), preferenceRequest2.getUserPreference());
						if(preferenceSaved){
							Response response2 = new Response(); 
							statusCode = StatusCode.STATUS_OK;
							response2.setStatusCode(StatusCode.STATUS_OK);
							response2.setStatusUserMessage("Preferences saved successfully");
							response2.setAccount(account);
							String json = gson.toJson(response2);
							System.out.println("getMealPassOption Response : "+json);
							try {
								response.getWriter().write(json);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}else{
						statusCode = StatusCode.ACCOUNT_INVALID;
					}
				}
			}
		}
		
		if(!Response.isStatusOk(statusCode)){
			Response response2 = new Response(); 
			response2.setStatusCode(statusCode);
			response2.setStatusUserMessage("Error in saving preference");
			String json = gson.toJson(response2);
			System.out.println("getMealPassOption Response : "+json);
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
