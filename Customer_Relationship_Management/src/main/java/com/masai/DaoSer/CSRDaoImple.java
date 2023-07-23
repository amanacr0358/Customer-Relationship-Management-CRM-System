package com.masai.DaoSer;


import java.util.List;


import com.masai.Entities.Csr;
import com.masai.Entities.Customer;
import com.masai.Entities.Issue;
import com.masai.Enum.Feedback;
import com.masai.Enum.IssueStatus;
import com.masai.Services.GetCustomerCredImpl;
import com.masai.Services.GetCustomerCreds;
import com.masai.Utility.GetEntityManagerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class CSRDaoImple implements CSRDao {

	
static EntityManagerFactory emf = GetEntityManagerFactory.getEntityManagerFactory();
	
	@Override
	public void addNewCSR(Csr csr) {
		
		EntityManager em = null;
		EntityTransaction et = null;
		String status = "CSR Couldn't registered";
		try {
			
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			 GetCustomerCreds getCustomerCreds = new GetCustomerCredImpl();
			 List<Customer> cusList = getCustomerCreds.getCustomerList();

			for(Customer cus : cusList) {
				cus.getCsr().add(csr);
				csr.getCustomer().add(cus);
				
				
			}
			
			et.begin();
			
			Csr mergeCSR = em.merge(csr);
			
			em.persist(mergeCSR);
			
			et.commit();
			
			status = "CSR "+ csr.getName()+" registered Successfully";
			
		} catch (Exception e) {
			
			et.rollback();
			
			System.out.println(e.getMessage());
			
		}finally {
			
			em.close();
			
		}
		
		System.out.println(status);
	}

	@Override
	public List<Issue> viewAllIssues() {
		List<Issue> issueList = null;
		try(EntityManager em = emf.createEntityManager()){
			
			String que = "SELECT i FROM Issue i";
			
			Query query = em.createQuery(que);
			
			 issueList = query.getResultList();
			
		}catch(IllegalArgumentException | IllegalStateException e ) {
			System.out.println(e.getMessage());
		}
		
		return issueList;
	}

	@Override
	public void manageIssue(int id , IssueStatus rev , Feedback feed ) {
		
		EntityManager em = null;
		EntityTransaction et = null;
		int executeUpdate = 0;
         try {
			
			em = emf.createEntityManager();
			et = em.getTransaction();
			
			String que = "UPDATE Issue i SET status=:st , feedback=:feed WHERE id=:id";

			Query query = em.createQuery(que);
			
			query.setParameter("st", rev);
			query.setParameter("feed", feed);
			query.setParameter("id", id);
			
			et.begin();
			 executeUpdate = query.executeUpdate();
			et.commit();
			
		} catch (Exception e) {
			
			et.rollback();
			
			System.out.println(e.getMessage());
			
		}finally {
			
			em.close();
			
		}
		
		if(executeUpdate>0) {
			System.out.println("Issue Status and Feedback Imparted Successfully");
		}else {
			System.out.println("Something Went Wrong");
		}
		
	}

	@Override
	public void viewFeedBackByCustomers() {
		
       try(EntityManager em = emf.createEntityManager()){
			
			String que = "SELECT i FROM Issue i";
			
			Query query = em.createQuery(que);
			
			List<Issue> issueList = query.getResultList();
			
			for(Issue issue : issueList) {
				System.out.println( "Customer "+issue.getCustomer().getName() +" , " +"Issue:-"+ issue.getStatus() +", Feedback:- " + issue.getFeedback() );
				
			}
			
		}catch(IllegalArgumentException | IllegalStateException e ) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
