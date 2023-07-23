package com.masai.Utility;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GetEntityManagerFactory {

	public static EntityManagerFactory getEntityManagerFactory() {

		return Persistence.createEntityManagerFactory("CustomerSupportRepresentative");
		
	}
	
	
}
