package com.neu.mealpass.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
import com.neu.mealpass.request.Request;
import com.neu.mealpass.response.Response;
import com.neu.mealpass.response.StatusCode;
import com.neu.mealpass.user.Account;
import com.neu.mealpass.utils.MD5Hashing;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SignUpController {
	
	private static final Logger logger = LoggerFactory.getLogger(SignUpController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/signup**", method = RequestMethod.POST)
	public void registerUser(HttpServletRequest request,HttpServletResponse response, @RequestBody String signupRequest){
		System.out.println("registerUser "+signupRequest);
		
		Gson gson = new Gson();
		StatusCode statusCode = StatusCode.STATUS_ERROR;
		
		
		if(signupRequest !=  null){
	    	Request responseRequest = gson.fromJson(signupRequest, Request.class);
	    	if(responseRequest != null && responseRequest.getUser() != null){
	    		Account account = responseRequest.getUser().getAccount();
				if(account != null){
					try {
						account.setPassword(MD5Hashing.getDecodedPassword(account.getPassword()));
						account.setToken(account.getUserName()+"_"+account.getPassword());
						Connection connection = ConnectionDao.getConnection();
						int row = ConnectionDao.createUserAccount(connection, account);
						if(row > -1){
						List<MealPassOption> mealPassOptions = MealPassConnectionDao.getMealPassOptions(connection);
								
						Response response2 = new Response(); 		
						response2.setAccount(account);
						response2.setMealPassOptions(mealPassOptions);
						statusCode = StatusCode.STATUS_OK;
						response2.setStatusCode(StatusCode.STATUS_OK);
						String json = gson.toJson(response2);
						System.out.println("registerUser Response : "+json);
						response.addHeader("Content-type", "application/json");
						response.setContentType("application/json");
						response.getWriter().write(json);
						
						}
							
					} catch (NoSuchAlgorithmException e) {
						e.printStackTrace();
					} catch (IOException e){
						e.printStackTrace();
					}
				}else{
					statusCode = StatusCode.ACCOUNT_INVALID;
				}
	    	}
	    }
	    
	    if(!Response.isStatusOk(statusCode)){
			Response response2 = new Response(); 
			response2.setStatusCode(statusCode);
			response2.setStatusUserMessage("Error in getting meal pass options");
			String json = gson.toJson(response2);
			System.out.println("registerUser Response : "+json);
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
