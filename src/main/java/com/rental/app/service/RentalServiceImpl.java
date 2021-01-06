package com.rental.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rental.app.dao.CarDAO;
import com.rental.app.dao.CustomerDAO;
import com.rental.app.dao.RentDAO;
import com.rental.app.entity.Car;
import com.rental.app.entity.Customer;
import com.rental.app.entity.Rent;

@Service
public class RentalServiceImpl implements RentalService {

	@Autowired
	private CarDAO carDAO;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private RentDAO rentDAO;
	
	@Override
	@Transactional
	public List<Car> getAllCars() {
		return carDAO.getAllCars();
	}

	@Override
	@Transactional
	public Car getCar(int id) {
		return carDAO.getCar(id);
	}

	@Override
	@Transactional
	public void saveCar(Car car) {
		if(car.getCarId()==0)
			car.setAvailable(true);
		carDAO.saveCar(car);
	}

	@Override
	@Transactional
	public void deleteCar(int id) {
		carDAO.deleteCar(id);
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}

	@Override
	@Transactional
	public Rent rentCar(int carId, int customerId) {
		
		
		Car car = carDAO.getCar(carId);
		
		if(!car.isAvailable()) {
			throw new CarNotAvailableException("Car of id " + carId + " is currently unavailable.");
		} else {
		
			Customer customer = customerDAO.getCustomer(customerId);
			Rent rent = new Rent();
			rent.setRentDate(LocalDateTime.now());
			car.addRent(rent);
			car.setAvailable(false);
			customer.addRent(rent);
		
			carDAO.saveCar(car);
			customerDAO.saveCustomer(customer);
			
			return rent;
		}
		
	}

	@Override
	@Transactional
	public void returnCar(int carId, int rentId) {
		
		Car car = carDAO.getCar(carId);
		
		if(car.isAvailable()) {
			throw new CarNotAvailableException("Car of id " + carId + " cannot be returned, as it is not rented.");
		} else {
		
			Rent rent = rentDAO.getRent(rentId);
		
			rent.setReturnDate(LocalDateTime.now());
			car.setAvailable(true);
			carDAO.saveCar(car);
		}
	}

	@Override
	@Transactional
	public List<Rent> getAllRents() {
		return rentDAO.getAllRents();
	}

	@Override
	@Transactional
	public Rent getRent(int id) {
		return rentDAO.getRent(id);
	}

	@Override
	@Transactional
	public void saveRent(Rent rent) {
		rentDAO.saveRent(rent);
	}

	@Override
	@Transactional
	public void deleteRent(int id) {
		rentDAO.deleteRent(id);
	}

}
