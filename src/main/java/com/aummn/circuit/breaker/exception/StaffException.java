package com.aummn.circuit.breaker.exception;

public class StaffException extends RuntimeException {

	public StaffException(String message) {
		super(message);
	}

    public StaffException(String message, Throwable cause) {
        super(message, cause);
    }
}