package com.airbus.exception;

import org.omg.CORBA.UserException;

@SuppressWarnings("serial")
public class NonPrivileged extends UserException {
	
	public NonPrivileged(String message) {
		super(message);
	}

	


}
