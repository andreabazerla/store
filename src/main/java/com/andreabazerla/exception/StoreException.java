package com.andreabazerla.exception;

public class StoreException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public StoreException(String message) {
		super(message);
	}
	
	public StoreException(Throwable t) {
		super(t);
	}

}
