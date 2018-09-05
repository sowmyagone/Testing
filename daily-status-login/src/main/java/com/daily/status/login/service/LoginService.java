package com.daily.status.login.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daily.status.login.dao.LoginDAO;


@Service("loginService")
@Transactional
public class LoginService {
	
	@Autowired
	LoginDAO loginDAO;
	
	public String loginData(JSONObject input){
		String employeeId=input.getString("employeeId");
		String password=input.getString("password");
		
		String loginDetail=loginDAO.loginData(employeeId,password);
		if(loginDetail==null){
			System.out.println("Invalid User");
			return "Invalid User";
		}
		else{
			System.out.println("Successfully Logged In");
			return "Login Success";
		}
	}

}
