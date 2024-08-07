package com.angel.application.interfaces.security;

public interface PasswordEncoder {

	String hash(String password);

	boolean verifyHash(String password, String hashedPassword);
}
