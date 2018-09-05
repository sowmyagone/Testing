package com.daily.status.login.controller;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daily.status.login.service.LoginService;



@Controller
@RequestMapping("/registration/login/get")
public class GetController {
	
	@Autowired
	LoginService loginService;
	
	public static final String PROCESS = "/data";
	
	@RequestMapping(value = GetController.PROCESS, method = RequestMethod.POST, produces = {"application/json" })
	public @ResponseBody String loginModule(@RequestBody String jsonRequest) throws IOException{
		
		JSONObject jsonData=new JSONObject(jsonRequest);
		String messageType=jsonData.getString("messageType");
		
		String result=null;
		
		if("LOGIN".equalsIgnoreCase(messageType)) {
			
			 result=loginService.loginData(jsonData.getJSONObject("jsonRequest"));

			
		}
			else {
				 result="Error Occured in Login Controller" ;
			}
				
				
				return result;
			}
		
	}
			



