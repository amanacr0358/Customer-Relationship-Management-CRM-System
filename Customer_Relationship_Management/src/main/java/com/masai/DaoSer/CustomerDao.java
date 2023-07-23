package com.masai.DaoSer;

import java.util.List;

import com.masai.Entities.Customer;
import com.masai.Entities.Issue;
import com.masai.Enum.Feedback;

public interface CustomerDao {

	public void addNewCustomer(Customer cus);
	public void createIssue( Issue issue);
	public List<Issue> viewAllIssuesAndGiveFeed(int id );
	public void giveFeedBackToIssues(int id  , Feedback feed);
}
