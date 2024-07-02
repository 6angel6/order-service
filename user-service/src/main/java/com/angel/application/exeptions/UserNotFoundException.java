package com.angel.application.exeptions;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(){
		super("USER NOT FOUND");
	}

}
