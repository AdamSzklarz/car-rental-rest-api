package com.rental.app.dao;

import java.util.List;

import com.rental.app.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getAllCustomers();
	
	public Customer getCustomer(int id);
	
	public void saveCustomer(Customer customer);
	
	public void deleteCustomer(int id);
}
