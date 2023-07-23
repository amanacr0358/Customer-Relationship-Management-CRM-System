package com.masai.Services;

import java.util.List;

import com.masai.DaoSer.CSRDao;
import com.masai.DaoSer.CSRDaoImple;
import com.masai.Entities.Csr;
import com.masai.Entities.Issue;
import com.masai.Enum.Feedback;
import com.masai.Enum.IssueStatus;

public class CSRServicesImple implements CSRServices{

	@Override
	public void addNewCSR(Csr csr) {
		
		CSRDao csrDao = new CSRDaoImple();
		
		csrDao.addNewCSR(csr);
		
	}

	@Override
	public List<Issue> viewAllIssues() {
		CSRDao csrDao = new CSRDaoImple();
		List<Issue> issueList = csrDao.viewAllIssues();
		return issueList;
	}

	@Override
	public void manageIssue(int id  , IssueStatus rev , Feedback feed ) {
		
		CSRDao csrDao = new CSRDaoImple();
		csrDao.manageIssue(id , rev , feed);
		
	}

	@Override
	public void viewFeedBackByCustomers() {
		
		CSRDao csrDao = new CSRDaoImple();
		
		csrDao.viewFeedBackByCustomers();
		
	}

}
