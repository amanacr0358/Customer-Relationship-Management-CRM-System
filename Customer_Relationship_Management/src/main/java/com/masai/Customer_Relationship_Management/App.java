package com.masai.Customer_Relationship_Management;

import java.util.Scanner;

import com.masai.CSR_OPS.CSROperation;
import com.masai.CustomerOPS.CustomerOperation;


public class App 
{
    public static void main( String[] args )
    {
     
    	Scanner sc = new Scanner(System.in);
    	String opt;
    	
    	do {
    		System.out.println(
    				"Welcome To Customer Relationship Management App" 
    		                  + "\n" +
    			  "1. Customer_Support_Representative Login"
    		                  + "\n" +
    		      "2. Customer_Support_Representative Registration"
    		                  + "\n" +
    			  "3. Customer Login"
    		                  + "\n" +
    		      "4. Customer Register"
    		                  + "\n" +
    			  "0. Exit From App..."
    				);
    		
    		opt = sc.next();

    		switch(opt) {
    		case "1" -> csrLogin(sc); 
    		case "2" -> csrRegistratiion(sc);
    		case "3" -> customerLogin(sc);
    		case "4" -> customerRegistratiion(sc);
    		case "0" -> System.out.println("Thanks For Using Services");
    		}
    	}while(!opt.equals("0"));
    	
    }
    
       
    private static void csrLogin(Scanner sc)  {
		 
		CSROperation csrOps = new CSROperation();
		
		csrOps.csrLogin(sc);
		 
	}
	
	private static void csrRegistratiion(Scanner sc) {
		
		CSROperation csrOps = new CSROperation();
		
		csrOps.csrRegistratiion(sc);
		
	}

	private static void customerLogin(Scanner sc) {
		  
		CustomerOperation cusOps = new CustomerOperation();
		
		cusOps.customerLogin(sc);
		
	}

	private static void customerRegistratiion(Scanner sc) {
		
		CustomerOperation cusOps = new CustomerOperation();
		
		cusOps.customerRegistration(sc);
		 
	}
}
