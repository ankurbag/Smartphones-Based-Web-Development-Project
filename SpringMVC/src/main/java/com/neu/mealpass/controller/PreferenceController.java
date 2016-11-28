package com.neu.mealpass.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.neu.mealpass.request.PreferenceRequest;
import com.neu.mealpass.user.Account;

@Controller
public class PreferenceController {

	private static final Logger logger = LoggerFactory.getLogger(PreferenceController.class);
	
	@RequestMapping(value = "/setpreference**", method = RequestMethod.POST)
	public void setPreference(HttpServletRequest request,HttpServletResponse response, @RequestBody String preferenceRequest){
		System.out.println("setPreference "+preferenceRequest);
		if(preferenceRequest != null){
			
			Gson gson = new Gson();
			PreferenceRequest preferenceRequest2 = gson.fromJson(preferenceRequest, PreferenceRequest.class);
			if(preferenceRequest2 != null){
				System.out.println("setPreference "+preferenceRequest2.getMealPortion());
				Account account = preferenceRequest2.getAccount();
				if(account != null){
					System.out.println("account "+account.getUserName() + " "+account.getPassword()+ " Token "+account.getToken());
				}
			}
			/*Account account = preferenceRequest.getAccount();
			if(account != null){
				boolean accountValid = ConnectionDao.isAccountValid(account);
				if(accountValid){
					
				}
			}*/
		}
		
		
	}
	
}
