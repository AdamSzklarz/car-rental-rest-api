package com.rental.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rental.app.entity.Car;
import com.rental.app.entity.Customer;

@Repository
public class CarDAOImpl implements CarDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Car> getAllCars() {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Car> query = 
				currentSession.createQuery("from Car",
													Car.class);

		List<Car> cars = query.getResultList();
		
		return cars;
	}

	@Override
	public Car getCar(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Car car = currentSession.get(Car.class, id);

		return car;
	}

	@Override
	public void saveCar(Car car) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(car);
	}

	@Override
	public void deleteCar(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = 
				currentSession.createQuery("delete from Car where id=:carId");
		query.setParameter("carId", id);
		
		query.executeUpdate();
	}

}
