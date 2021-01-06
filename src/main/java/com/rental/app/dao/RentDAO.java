package com.rental.app.dao;

import java.util.List;

import com.rental.app.entity.Car;
import com.rental.app.entity.Rent;

public interface RentDAO {

	public List<Rent> getAllRents();
	
	public Rent getRent(int id);
	
	public void saveRent(Rent rent);
	
	public void deleteRent(int id);
}
