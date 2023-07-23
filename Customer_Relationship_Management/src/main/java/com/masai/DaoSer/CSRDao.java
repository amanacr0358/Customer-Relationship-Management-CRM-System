package com.masai.DaoSer;

import java.util.List;

import com.masai.Entities.Csr;
import com.masai.Entities.Issue;
import com.masai.Enum.Feedback;
import com.masai.Enum.IssueStatus;

public interface CSRDao {

	 public void addNewCSR(Csr csr);
	 public List<Issue> viewAllIssues();
	 public void manageIssue(int id , IssueStatus rev , Feedback feed );
	 public void viewFeedBackByCustomers();
}
