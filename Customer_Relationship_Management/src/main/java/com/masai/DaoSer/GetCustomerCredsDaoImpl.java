package com.masai.DaoSer;

import java.util.List;

import com.masai.Entities.Customer;
import com.masai.Utility.GetEntityManagerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class GetCustomerCredsDaoImpl implements GetCustomerCredsDao{

	static EntityManagerFactory emf = GetEntityManagerFactory.getEntityManagerFactory();
	
	@Override
	public List<Customer> getCustomerList() {

			List<Customer> resultList = null;
			
			try(EntityManager em = emf.createEntityManager()){
				
	            String getCredsQue = "SELECT c FROM Customer c";
				
				Query createQuery = em.createQuery(getCredsQue);
				
				 resultList =  createQuery.getResultList();
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return resultList;
	}

}
