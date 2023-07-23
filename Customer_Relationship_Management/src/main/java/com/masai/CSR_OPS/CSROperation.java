package com.masai.CSR_OPS;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import com.masai.Entities.Csr;
import com.masai.Entities.Customer;
import com.masai.Entities.Issue;
import com.masai.Enum.Feedback;
import com.masai.Enum.IssueStatus;
import com.masai.Services.CSRServices;
import com.masai.Services.CSRServicesImple;
import com.masai.Services.GetCSRCreds;
import com.masai.Services.GetCSRCredsImpl;
import com.masai.Services.GetCustomerCredImpl;
import com.masai.Services.GetCustomerCreds;

public class CSROperation {

	public  void csrLogin(Scanner sc) {

		System.out.println("Enter Admin UseName ");
		String userName = sc.next();
		
		System.out.println("Enter Admin PassWord ");
		String passWord = sc.next();
		System.out.println();
		GetCSRCreds getCSRCreds = new GetCSRCredsImpl();
		
		List<Csr> csrUserPass = getCSRCreds.getCSRUserPass();
		
		csrUserPass.forEach( c -> {
			if(c.getUserName().equals(userName)&&c.getPassWord().equals(passWord)) {	
				System.out.println("Welcome CSR:- "+c.getName());
				System.out.println();
				adminFieldsExc(sc);
			  }
		});
			
	}
	
	public  void csrRegistratiion(Scanner sc) {
		
		System.out.println("Enter User_Name");
		String userName = sc.next();
		System.out.println("Enter PassWord");
		String passWord = sc.next();
		System.out.println("Enter Name");
		String name = sc.next();
		System.out.println("Enter Email");
		String email = sc.next();
		System.out.println("Enter Address");
		String address = sc.next();
		
		Csr csr = new Csr(userName, passWord, name, email, address, new HashSet<>());
		
		CSRServices csrSer = new CSRServicesImple();
		
		csrSer.addNewCSR(csr);
		
	}
		
public static void adminFieldsExc(Scanner sc) {
		
		String opt;
		
		do {
			displayAdminFields();
			System.out.println();
			System.out.println("Enter Your Preference...");
			opt = sc.next();
			
			switch(opt) {
			
			case "1" -> viewAllIssues(sc);
			case "2" -> viewAllCustomers();
			case "3" -> viewFeedBackByCustomers();
			case "0" -> System.out.println("Logged Out From Admin Account");
			}
			
		}while(!opt.equals("0"));
		
		
	}
	

private static void viewAllIssues(Scanner sc) {
	 
	CSRServices csrSer = new CSRServicesImple();
	
	IssueStatus rev = null;
	Feedback feed = null;
	 
	List<Issue> issueList = csrSer.viewAllIssues();
	for(Issue i : issueList ) {
		System.out.println(i);
	}
	
	
	System.out.println("Enter Id of the issue You wnat to resolve");
	
	int id = sc.nextInt();
	
	System.out.println(
			            "1. To Address And Close The Issue"
	                     +"\n"+
			               "2. WIll be Looked :- Pending"
	                        +"\n"+
			                  "Press any. TO Reject The Issue..");
	int opt = sc.nextInt();
	if(opt==1) rev = IssueStatus.CLOSED;
	else if(opt==2) rev = IssueStatus.PENDING;
	else rev = IssueStatus.REJECTED;

	System.out.println();
	
	System.out.println("Give Some Remark TO Issue");
	System.out.println(
		  "1. HAPPY_LOOKING_TO_YR_ISSUE"
	        +"\n"+
			"2. ISSUE_IS_ADDRESSED_NOW "		
			 +"\n"+
				"3. ISSUE_NOT_MEANT_TO_BE_ADDRESSED "
				 +"\n"+
					"4. WRONG_CATEGORY_CHOOSEN "
					 +"\n"+
						"5. WAS_HORRIBLE_ADDRESSING_ISSUE"
						+"\n"+
						   "Press Any. DO_NOT_RAISE_ISSUE_EVER_AGAIN_PLEASE;"
			);
	
	int choice = sc.nextInt();
	
	if(choice==1) feed = Feedback.HAPPY_ADDRESSING_YOUR_ISSUE;
	else if(choice == 2) feed = Feedback.ISSUE_IS_ADDRESSED_NOW;
	else if(choice == 3) feed = Feedback.ISSUE_NOT_MEANT_TO_BE_ADDRESSED;
	else if(choice == 4) feed = Feedback.WRONG_CATEGORY_CHOOSEN;
	else if(choice == 5) feed = Feedback.WAS_HORRIBLE_ADDRESSING_ISSUE;
	else feed = Feedback.DO_NOT_RAISE_ISSUE_EVER_AGAIN_PLEASE;
	
	csrSer.manageIssue(id , rev , feed);
} 

private static void viewAllCustomers() {
	 
GetCustomerCreds getCustomerCreds = new GetCustomerCredImpl();
	List<Customer> customerList = getCustomerCreds.getCustomerList();
	customerList.forEach(System.out::println);
}

private static void viewFeedBackByCustomers() {
	
	CSRServices csrSer = new CSRServicesImple();
	
	csrSer.viewFeedBackByCustomers();
	 
}

public static void displayAdminFields() {
	
	System.out.println(
			
		  "1. View All Issues of Customers AND Manage Them"
	                  + "\n" +
	      "2. View All Customers"
	                  + "\n" +	  
	      "3. View feedback given by customers on closed issues"
	                  + "\n" +
		  "0. Log out from the customer support representative account"
			
			);
	
}

	
	
}
