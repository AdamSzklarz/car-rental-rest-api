package com.rental.app.service;

import java.util.List;

import com.rental.app.entity.Car;
import com.rental.app.entity.Customer;
import com.rental.app.entity.Rent;

public interface RentalService {

	public List<Car> getAllCars();
	public Car getCar(int id);
	public void saveCar(Car car);
	public void deleteCar(int id);
	
	public List<Customer> getAllCustomers();	
	public Customer getCustomer(int id);	
	public void saveCustomer(Customer customer);
	public void deleteCustomer(int id);
	
	public Rent rentCar(int carId, int customerId);
	public void returnCar(int carId, int rentId);
	
	public List<Rent> getAllRents();	
	public Rent getRent(int id);	
	public void saveRent(Rent rent);
	public void deleteRent(int id);
}
