package com.masai.Services;

import java.util.List;

import com.masai.DaoSer.GetCustomerCredsDao;
import com.masai.DaoSer.GetCustomerCredsDaoImpl;
import com.masai.Entities.Customer;

public class GetCustomerCredImpl implements GetCustomerCreds{

	@Override
	public List<Customer> getCustomerList() {
		
		GetCustomerCredsDao cusCreds = new GetCustomerCredsDaoImpl();
		
		List<Customer> customerList = cusCreds.getCustomerList();
		
		return customerList;
	}

}
