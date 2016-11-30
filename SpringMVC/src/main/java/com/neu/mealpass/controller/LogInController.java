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
public class LogInController {
	
	private static final Logger logger = LoggerFactory.getLogger(LogInController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login**", method = RequestMethod.POST)
	public void loginUser(HttpServletRequest request,HttpServletResponse response, @RequestBody String loginRequest){
		System.out.println("setPreference "+loginRequest);
		if(loginRequest != null){
			JSONObject jObject  = new JSONObject(loginRequest); // json
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
			
			Connection connection = ConnectionDao.getConnection();
			Account account = ConnectionDao.loginUser(connection, userName, password);
			try {
				if(account!=null)
					response.getWriter().write("User Account with token: " + account.getToken());
				else
					response.getWriter().write("User Account not found");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
