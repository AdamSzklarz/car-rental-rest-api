package com.rental.app.dao;

import java.util.List;

import com.rental.app.entity.Car;

public interface CarDAO {

	public List<Car> getAllCars();
	
	public Car getCar(int id);
	
	public void saveCar(Car car);
	
	public void deleteCar(int id);
}
