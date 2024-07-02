package com.angel.application.exeptions;


public class PasswordsDoNotMatch extends RuntimeException {

	public PasswordsDoNotMatch() {
		super("Given password doesn't match with the actual one.");
	}
}