package com.daily.status.login.dao;

import org.springframework.stereotype.Repository;

import com.daily.status.login.entity.Login;


@Repository
public class LoginDAO  extends BaseDAO<Login> {
	
	
	public String loginData(String employeeId,String password){
	Login instances=null;
	
	try{
		instances=entityManager.createQuery("select u from Login u where u.employeeId=:employeeId and u.password=:password",Login.class).setParameter("employeeId", employeeId).setParameter("password", password).getSingleResult();
	return instances.toString();
	}
	catch(Exception e){
		return null;
	}

}
}