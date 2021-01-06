package com.rental.app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rent")
public class Rent {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rent_id")
	private int rentId;

	@Column(name="rent_date")
	private LocalDateTime rentDate;
	
	@Column(name="return_date")
	private LocalDateTime returnDate;
	
	public Rent() {
		
	}
	
	public int getRentId() {
		return rentId;
	}

	public void setRentId(int rentId) {
		this.rentId = rentId;
	}

	public LocalDateTime getRentDate() {
		return rentDate;
	}

	public void setRentDate(LocalDateTime rentDate) {
		this.rentDate = rentDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Rent [rentId=" + rentId + ", rentDate=" + rentDate
				+ ", returnDate=" + returnDate + "]";
	}
}
