package com.neu.mealpass.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.neu.mealpass.request.Request;
import com.neu.mealpass.response.Response;
import com.neu.mealpass.response.StatusCode;
import com.neu.mealpass.user.Account;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

@Controller
public class BotController {

	private static final String TAG = "BotController ";
	public static String API_AI_TOKEN = "b0501537e79741b9ac8bec8f030b2637";
	
	@RequestMapping(value = "/botHelp**", method = RequestMethod.POST)
	public void botMessage(HttpServletRequest request,HttpServletResponse response, @RequestBody String requestBody){
	
		System.out.println(TAG+" botMessage "+requestBody);
		StatusCode statusCode = StatusCode.STATUS_ERROR;
		Gson gson = new Gson();
		if(requestBody != null){
			Request responseRequest = gson.fromJson(requestBody, Request.class);
			Account account = responseRequest.getAccount();
			String botMessage = responseRequest.getBotMessage();
			System.out.println(TAG + "botMessage  : "+botMessage);
			if(botMessage != null){
				AIConfiguration configuration = new AIConfiguration(API_AI_TOKEN);
				AIDataService dataService = new AIDataService(configuration);
				try {
					AIRequest aiRequest = new AIRequest(botMessage);

					AIResponse aiResponse = dataService.request(aiRequest);

					if (aiResponse.getStatus().getCode() == 200) {
						System.out.println(aiResponse.getResult().getFulfillment().getSpeech());
						Response response2 = new Response(); 
						statusCode = StatusCode.STATUS_OK;
						response2.setStatusCode(statusCode);
						response2.setStatusUserMessage(aiResponse.getResult().getFulfillment().getSpeech());
						String json = gson.toJson(response2);
						System.out.println("botMessage Response : "+json);
						try {
							response.getWriter().write(json);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						System.err.println(aiResponse.getStatus().getErrorDetails());
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
		if(!Response.isStatusOk(statusCode)){
			Response response2 = new Response(); 
			response2.setStatusCode(statusCode);
			response2.setStatusUserMessage("Error in botMessage ");
			String json = gson.toJson(response2);
			System.out.println("botMessage Response : "+json);
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
