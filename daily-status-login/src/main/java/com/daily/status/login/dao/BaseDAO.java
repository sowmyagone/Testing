package com.daily.status.login.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class BaseDAO<E> {
	@PersistenceContext
	protected EntityManager entityManager;
	
	public E findById(Class<E> type,Integer id){
		E instance=null;
		try{
			instance=entityManager.find(type, id);
		}
		catch(Exception e){
			
		}
		return instance;

	}
	
	
	public E merge(E e) throws Exception{
		
		try{
			E result=entityManager.merge(e);
			return result;
			
		}
		catch(Exception re){
			throw re;
			
		}
		

	}
	


}
