package com.neu.mealpass.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.neu.mealpass.dao.ConnectionDao;
import com.neu.mealpass.dao.MealPassConnectionDao;
import com.neu.mealpass.meal.MealPass;
import com.neu.mealpass.meal.RestaurantMeal;
import com.neu.mealpass.request.MealRequest;
import com.neu.mealpass.request.Request;
import com.neu.mealpass.response.Response;
import com.neu.mealpass.response.StatusCode;
import com.neu.mealpass.user.Account;
import com.neu.mealpass.user.User;

@Controller
public class MealController {
	
	private static final String TAG = "MealController ";
	
	@RequestMapping(value = "/getMeals**", method = RequestMethod.POST)
	public void getAllMeals(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody){
		System.out.println(TAG+" getAllMeals "+requestBody);
		StatusCode statusCode = StatusCode.STAUS_ERROR;
		Gson gson = new Gson();
		if(requestBody != null){
			Request responseRequest = gson.fromJson(requestBody, Request.class);
			Account account = responseRequest.getAccount();
			if(account != null){
				Connection connection = ConnectionDao.getConnection();
				if(ConnectionDao.isAccountValid(connection, account)){
					User user = responseRequest.getUser();
					if(user != null){
						List<RestaurantMeal> restaurantMeals = MealPassConnectionDao.getTodaysRestaurantMeal(connection, user.getId());
						Response response2 = new Response(); 
						response2.setRestaurantMeal(restaurantMeals);
						response2.setAccount(account);
						statusCode = StatusCode.STATUS_OK;
						response2.setStatusCode(StatusCode.STATUS_OK);
						String json = gson.toJson(response2);
						System.out.println("getAllMeals Response : "+json);
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
		
		if(!Response.isStatusOk(statusCode)){
			Response response2 = new Response(); 
			response2.setStatusCode(statusCode);
			response2.setStatusUserMessage("Error in getting meals");
			String json = gson.toJson(response2);
			System.out.println("getAllMeals Response : "+json);
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value = "/orderMeal**", method = RequestMethod.POST)
	public void orderMeal(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody){
	
		System.out.println(TAG+" orderMeal "+requestBody);
		StatusCode statusCode = StatusCode.STAUS_ERROR;
		Gson gson = new Gson();
		if(requestBody != null){
			MealRequest responseRequest = gson.fromJson(requestBody, MealRequest.class);
			Account account = responseRequest.getAccount();
			if(account != null){
				Connection connection = ConnectionDao.getConnection();
				if(ConnectionDao.isAccountValid(connection, account)){
					User user = responseRequest.getUser();
					if(user != null){
						
						String mealId = responseRequest.getMealId();
						MealPass mealPass = MealPassConnectionDao.orderMeal(connection, mealId, user.getId());
						if(mealPass.isActive()){
							Response response2 = new Response(); 
							response2.setAccount(account);
							statusCode = StatusCode.STATUS_OK;
							response2.setStatusCode(StatusCode.STATUS_OK);
							String json = gson.toJson(response2);
							System.out.println("orderMeal Response : "+json);
							try {
								response.getWriter().write(json);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					
					
				}else{
					statusCode = StatusCode.ACCOUNT_INVALID;
				}
			}
		}
		
		if(!Response.isStatusOk(statusCode)){
			Response response2 = new Response(); 
			response2.setStatusCode(statusCode);
			response2.setStatusUserMessage("Error in ordering meals");
			String json = gson.toJson(response2);
			System.out.println("orderMeal Response : "+json);
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	@RequestMapping(value = "/deleteMeal**", method = RequestMethod.POST)
	public void deleteMeal(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody){
	
		System.out.println(TAG+" deleteMeal "+requestBody);
		StatusCode statusCode = StatusCode.STAUS_ERROR;
		Gson gson = new Gson();
		if(requestBody != null){
			MealRequest responseRequest = gson.fromJson(requestBody, MealRequest.class);
			Account account = responseRequest.getAccount();
			if(account != null){
				Connection connection = ConnectionDao.getConnection();
				if(ConnectionDao.isAccountValid(connection, account)){
					User user = responseRequest.getUser();
					if(user != null){
						
						String mealId = responseRequest.getMealId();
						MealPass mealPass = MealPassConnectionDao.deleteMeal(connection, mealId, user.getId());
						if(mealPass.isActive()){
							Response response2 = new Response(); 
							response2.setAccount(account);
							statusCode = StatusCode.STATUS_OK;
							response2.setStatusCode(StatusCode.STATUS_OK);
							String json = gson.toJson(response2);
							System.out.println("deleteMeal Response : "+json);
							try {
								response.getWriter().write(json);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					
					
				}else{
					statusCode = StatusCode.ACCOUNT_INVALID;
				}
			}
		}
		
		if(!Response.isStatusOk(statusCode)){
			Response response2 = new Response(); 
			response2.setStatusCode(statusCode);
			response2.setStatusUserMessage("Error in deleting meals");
			String json = gson.toJson(response2);
			System.out.println("deleteMeal Response : "+json);
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
