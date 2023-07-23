package com.masai.Services;

import java.util.List;

import com.masai.Entities.Csr;
import com.masai.Entities.Issue;
import com.masai.Enum.Feedback;
import com.masai.Enum.IssueStatus;

public interface CSRServices {

	 public void addNewCSR(Csr csr);
	 public List<Issue> viewAllIssues();
	 public void manageIssue(int id , IssueStatus rev , Feedback feed );
	 public void viewFeedBackByCustomers();
}
