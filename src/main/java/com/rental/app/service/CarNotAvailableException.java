package com.rental.app.service;

public class CarNotAvailableException extends RuntimeException {

	public CarNotAvailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public CarNotAvailableException(String message) {
		super(message);
	}

	public CarNotAvailableException(Throwable cause) {
		super(cause);
	}
	
}
