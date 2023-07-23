package com.masai.Customer_Relationship_Management;

import java.util.List;

import com.masai.Entities.Issue;
import com.masai.Enum.IssueStatus;
import com.masai.Utility.GetEntityManagerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class Test{
	
/*
	static EntityManagerFactory emf = GetEntityManagerFactory.getEntityManagerFactory();

public static void manageIssue(int id , IssueStatus rev) {
		
		EntityManager em = null;
		EntityTransaction et = null;
		
         try {
			
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			String que = "UPDATE Issue i SET status=:st WHERE id=:id";

			Query query = em.createQuery(que);
			
			query.setParameter("st", rev);
			query.setParameter("id", id);
			
			
			et.begin();
			
			query.executeUpdate();
			
			et.commit();
			
		} catch (Exception e) {
			
			et.rollback();
			
			System.out.println(e.getMessage());
			
		}finally {
			
			em.close();
			
		}
}

public static  void viewAllIssuesAndGiveFeed(int id) {
	
	
	
	try(EntityManager em = emf.createEntityManager()){
		
        String getIssues = "SELECT c FROM Issue c WHERE c.customer_id=:id";
		
		Query createQuery = em.createQuery(getIssues);
		
		createQuery.setParameter("id", id);
		
		List<Issue> issueList = (List<Issue>) createQuery.getResultList();
		
		for(Issue is : issueList) {
			System.out.println(is);
		}
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
	
}
*/
	public static void main(String[] args) {
//		
		
//		viewAllIssuesAndGiveFeed(1);
		  
//		manageIssue(1 , IssueStatus.CLOSED);
//		 byte b=10;
//		 int i = b;
//		 System.out.println(b+" "+i);
//		List<Integer> list = new ArrayList<>();
//		list.add(5);
//		list.add(8);
//		Set<Integer> set = new HashSet<>(list);
//		
//		
//		System.out.println(set);
//		
	}
	
}