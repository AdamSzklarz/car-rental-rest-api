package com.rental.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rental.app.entity.Car;
import com.rental.app.entity.Rent;

@Repository
public class RentDAOImpl implements RentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Rent> getAllRents() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Rent> query = 
				currentSession.createQuery("from Rent", Rent.class);

		List<Rent> rents = query.getResultList();
		
		return rents;
	}

	@Override
	public Rent getRent(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Rent rent = currentSession.get(Rent.class, id);

		return rent;
	}

	@Override
	public void saveRent(Rent rent) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(rent);
	}

	@Override
	public void deleteRent(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = 
				currentSession.createQuery("delete from Rent where id=:rentId");
		query.setParameter("rentId", id);
		
		query.executeUpdate();

	}

}
