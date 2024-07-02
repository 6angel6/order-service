package com.angel.application.exeptions;

public class RoleNotFoundException extends RuntimeException{

	public RoleNotFoundException() {
		super("Such role wasn't found.");
	}
}
