package com.masai.DaoSer;

import java.util.List;

import com.masai.Entities.Csr;
import com.masai.Utility.GetEntityManagerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class GetCSRCredsdDaoImp implements GetCSRCredsdDao{

	static EntityManagerFactory emf = GetEntityManagerFactory.getEntityManagerFactory();
	
	@Override
	public List<Csr> getCSRUserPass() {
		
		List<Csr> resultList = null;
		
		try(EntityManager em = emf.createEntityManager()){
			
            String getCredsQue = "SELECT c FROM Csr c";
			
			Query createQuery = em.createQuery(getCredsQue);
			
			 resultList =  createQuery.getResultList();
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return resultList;
	}


	
}
