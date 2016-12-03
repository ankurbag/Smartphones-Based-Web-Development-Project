package com.neu.mealpass.controller;

import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.neu.mealpass.dao.ConnectionDao;
import com.neu.mealpass.request.PreferenceRequest;
import com.neu.mealpass.request.SignupRequest;
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
		System.out.println("setPreference "+signupRequest);
		if(signupRequest != null){
			JSONObject jObject  = new JSONObject(signupRequest); // json
			String userName = jObject.getString("userName");
			String password = "";
			try {
				password = MD5Hashing.getDecodedPassword(jObject.getString("password"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Account account = new Account();
			account.setUserName(userName);
			account.setPassword(password);
			account.setToken(userName+"_"+password);
			
			Connection connection = ConnectionDao.getConnection();
			
			int row = ConnectionDao.createUserAccount(connection, account);
			try {
				response.getWriter().write(row > 0?"success":"failed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					response.getWriter().write(e.getMessage());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		
	}
	
}
