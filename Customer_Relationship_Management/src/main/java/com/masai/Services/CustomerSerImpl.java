package com.masai.Services;

import java.util.List;

import com.masai.DaoSer.CustomerDao;
import com.masai.DaoSer.CustomerDaoImpl;
import com.masai.Entities.Customer;
import com.masai.Entities.Issue;
import com.masai.Enum.Feedback;

public class CustomerSerImpl implements CustomerService{

	@Override
	public void addNewCustomer(Customer cus) {
		
		CustomerDao cusDao = new CustomerDaoImpl();
		
		cusDao.addNewCustomer(cus);
		
	}

	@Override
	public void createIssue(Issue issue) {
		

		CustomerDao cusDao = new CustomerDaoImpl();
		
		cusDao.createIssue(issue);
	}

	@Override
	public List<Issue> viewAllIssuesAndGiveFeed(int id) {
	
		CustomerDao cusDao = new CustomerDaoImpl();
		List<Issue> issueList = cusDao.viewAllIssuesAndGiveFeed(id);
		return issueList;
	}

	@Override
	public void giveFeedBackToIssues(int id, Feedback feed) {
		
		CustomerDao cusDao = new CustomerDaoImpl();
		cusDao.giveFeedBackToIssues(id, feed);
	}

}
