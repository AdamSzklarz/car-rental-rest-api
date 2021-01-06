package com.rental.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rental.app.entity.Car;
import com.rental.app.entity.Customer;
import com.rental.app.entity.Rent;
import com.rental.app.service.RentalService;

@RestController
@RequestMapping("/api")
public class RentalRestController {

	@Autowired
	private RentalService rentalService;
	
	@GetMapping("/cars")
	public List<Car> getAllCars(){
		return rentalService.getAllCars();
	}
	
	@GetMapping("/cars/{carId}")
	public Car getCar(@PathVariable int carId) {
		
		Car car = rentalService.getCar(carId);
		
		if(car == null) {
			throw new ElementNotFoundException("Car of id " + carId + " does not exist");
		}
		
		return car;
	}
	
	@PostMapping("/cars")
	public Car addCar(@RequestBody Car car) {
		
		// setting id to 0 to inform rentalService that we need to insert a new car
		car.setCarId(0);
		
		rentalService.saveCar(car);
		return car;
	}
	
	@PutMapping("/cars")
	public Car updateCar(@RequestBody Car car) {
		
		rentalService.saveCar(car);
		
		return car;
	}
	
	@DeleteMapping("/cars/{carId}")
	public String deleteCar(@PathVariable int carId) {
		
		Car car = rentalService.getCar(carId);
		
		if(car == null) {
			throw new ElementNotFoundException("Car of id " + carId + " does not exist");
		}
		
		rentalService.deleteCar(carId);
		
		return "Car of id " + carId + " successfully deleted";
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return rentalService.getAllCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer customer = rentalService.getCustomer(customerId);
		
		if(customer == null) {
			throw new ElementNotFoundException("Customer of id " + customerId + " does not exist");
		}
		
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		// // setting id to 0 to inform rentalService that we need to insert a new customer
		customer.setCustomerId(0);
		
		rentalService.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		rentalService.saveCustomer(customer);
		
		return customer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer customer = rentalService.getCustomer(customerId);
		
		if(customer == null) {
			throw new ElementNotFoundException("Customer of id " + customerId + " does not exist");
		}
		
		rentalService.deleteCustomer(customerId);
		
		return "Customer of id " + customerId + " successfully deleted";
	}
	
	@GetMapping("/rents")
	public List<Rent> getAllRents(){
		return rentalService.getAllRents();
	}
	
	@GetMapping("/rents/{rentId}")
	public Rent getRent(@PathVariable int rentId) {
		
		Rent rent = rentalService.getRent(rentId);
		
		if(rent == null) {
			throw new ElementNotFoundException("Rent of id " + rentId + " does not exist");
		}
		
		return rent;
	}
	
	@PostMapping("/rents/{carId}/{customerId}")
	public Rent addRent(@PathVariable Integer carId, @PathVariable Integer customerId) {		
		
		Car car = rentalService.getCar(carId);
		Customer customer = rentalService.getCustomer(customerId);
		
		if(car == null) {
			throw new ElementNotFoundException("Car of id " + carId + " does not exist");
		} else if(customer == null) {
			throw new ElementNotFoundException("Customer of id " + customerId + " does not exist");
		}
		
		return rentalService.rentCar(carId, customerId);
	}
	
	@PutMapping("/rents/{rentId}/{carId}")
	public String endRent(@PathVariable int rentId, @PathVariable int carId) {
		
		Rent rent = rentalService.getRent(rentId);
		Car car = rentalService.getCar(carId);
		
		if(rent == null) {
			throw new ElementNotFoundException("Rent of id " + rentId + " does not exist");
		} else if(car == null) {
			throw new ElementNotFoundException("Car of id " + carId + " does not exist");
		}
		
		rentalService.returnCar(carId, rentId);
		
		return "Car of id " + carId + " successfully returned.";
	}
	
}
