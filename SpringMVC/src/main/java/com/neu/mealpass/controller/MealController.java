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
import com.neu.mealpass.meal.MealPassOption;
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
		StatusCode statusCode = StatusCode.STATUS_ERROR;
		Gson gson = new Gson();
		if(requestBody != null){
			Request responseRequest = gson.fromJson(requestBody, Request.class);
			Account account = responseRequest.getAccount();
			Connection connection = ConnectionDao.getConnection();
			User user = ConnectionDao.getUser(connection, account.getUserName());
			MealPass mealPass = MealPassConnectionDao.getUserMealPass(connection, account.getUserName());
			List<MealPassOption> mealPassOptions = null;
			if(mealPass == null){
				mealPassOptions = MealPassConnectionDao.getMealPassOptions(connection);
			}
			RestaurantMeal restaurantMeal = MealPassConnectionDao.getUserMeal(connection, account.getUserName());
			boolean mealOrdered = false;
			if(restaurantMeal !=null){
				mealOrdered = true;
			}
			if(account != null){
				if(ConnectionDao.isAccountValid(connection, account)){
					if(user != null){
						List<RestaurantMeal> restaurantMeals = MealPassConnectionDao.getTodaysRestaurantMeal(connection, user.getId());
						Response response2 = new Response(); 
						response2.setRestaurantMeal(restaurantMeals);
						response2.setAccount(account);
						response2.setUser(user);
						response2.setMealPass(mealPass);
						response2.setMealOrdered(mealOrdered);
						response2.setMealPassOptions(mealPassOptions);
						response2.setUserRestaurantMeal(restaurantMeal);
						statusCode = StatusCode.STATUS_OK;
						response2.setStatusCode(StatusCode.STATUS_OK);
						String json = gson.toJson(response2);
						System.out.println("getAllMeals Response : "+json);
						try {
							response.addHeader("Content-type", "application/json");
							response.setContentType("application/json");
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
				response.addHeader("Content-type", "application/json");
				response.setContentType("application/json");
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value = "/orderMeal**", method = RequestMethod.POST)
	public void orderMeal(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody){
	
		System.out.println(TAG+" orderMeal "+requestBody);
		StatusCode statusCode = StatusCode.STATUS_ERROR;
		Gson gson = new Gson();
		if(requestBody != null){
			MealRequest responseRequest = gson.fromJson(requestBody, MealRequest.class);
			Account account = responseRequest.getAccount();
			if(account != null){
				Connection connection = ConnectionDao.getConnection();
				if(ConnectionDao.isAccountValid(connection, account)){
					User user = responseRequest.getUser();
					if(user != null){
						
						RestaurantMeal restaurantMeal = responseRequest.getRestaurantMeal();
						MealPass mealPass = MealPassConnectionDao.orderMeal(connection, restaurantMeal, account.getUserName());
						if(mealPass.isActive()){
							Response response2 = new Response(); 
							response2.setAccount(account);
							statusCode = StatusCode.STATUS_OK;
							response2.setStatusCode(StatusCode.STATUS_OK);
							String json = gson.toJson(response2);
							System.out.println("orderMeal Response : "+json);
							try {
								response.addHeader("Content-type", "application/json");
								response.setContentType("application/json");
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
				response.addHeader("Content-type", "application/json");
				response.setContentType("application/json");
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	@RequestMapping(value = "/deleteMeal**", method = RequestMethod.POST)
	public void deleteMeal(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody){
	
		System.out.println(TAG+" deleteMeal "+requestBody);
		StatusCode statusCode = StatusCode.STATUS_ERROR;
		Gson gson = new Gson();
		if(requestBody != null){
			MealRequest responseRequest = gson.fromJson(requestBody, MealRequest.class);
			Account account = responseRequest.getAccount();
			if(account != null){
				Connection connection = ConnectionDao.getConnection();
				if(ConnectionDao.isAccountValid(connection, account)){
					User user = responseRequest.getUser();
					if(user != null){
						
						RestaurantMeal restaurantMeal = responseRequest.getRestaurantMeal();
						MealPass mealPass = MealPassConnectionDao.deleteMeal(connection, ""+restaurantMeal.getMeal().getId(), account.getUserName());
						if(mealPass.isActive()){
							Response response2 = new Response(); 
							response2.setAccount(account);
							statusCode = StatusCode.STATUS_OK;
							response2.setStatusCode(StatusCode.STATUS_OK);
							String json = gson.toJson(response2);
							System.out.println("deleteMeal Response : "+json);
							try {
								response.addHeader("Content-type", "application/json");
								response.setContentType("application/json");
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
	
	@RequestMapping(value = "/mealHistory**", method = RequestMethod.POST)
	public void getmealHistory(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody){
		System.out.println(TAG+" getmealHistory "+requestBody);
		StatusCode statusCode = StatusCode.STATUS_ERROR;
		Gson gson = new Gson();
		if(requestBody != null){
			Request responseRequest = gson.fromJson(requestBody, Request.class);
			Account account = responseRequest.getAccount();
			Connection connection = ConnectionDao.getConnection();
			User user = ConnectionDao.getUser(connection, account.getUserName());
			MealPass mealPass = MealPassConnectionDao.getUserMealPass(connection, account.getUserName());
			List<MealPassOption> mealPassOptions = null;
			if(mealPass == null){
				mealPassOptions = MealPassConnectionDao.getMealPassOptions(connection);
			}
			RestaurantMeal restaurantMeal = MealPassConnectionDao.getUserMeal(connection, account.getUserName());
			boolean mealOrdered = false;
			if(restaurantMeal !=null){
				mealOrdered = true;
			}
			if(account != null){
				if(ConnectionDao.isAccountValid(connection, account)){
					if(user != null){
						List<RestaurantMeal> restaurantMeals = MealPassConnectionDao.getHistoryRestaurantMeal(connection, account.getUserName());
						Response response2 = new Response(); 
						response2.setRestaurantMeal(restaurantMeals);
						response2.setAccount(account);
						response2.setUser(user);
						response2.setMealPass(mealPass);
						response2.setMealOrdered(mealOrdered);
						response2.setMealPassOptions(mealPassOptions);
						response2.setUserRestaurantMeal(restaurantMeal);
						statusCode = StatusCode.STATUS_OK;
						response2.setStatusCode(StatusCode.STATUS_OK);
						String json = gson.toJson(response2);
						System.out.println("getAllMeals Response : "+json);
						try {
							response.addHeader("Content-type", "application/json");
							response.setContentType("application/json");
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
				response.addHeader("Content-type", "application/json");
				response.setContentType("application/json");
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
