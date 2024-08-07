package com.angel.infrastructure.security;

import com.angel.application.interfaces.security.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordEncoderImpl implements PasswordEncoder {

	@Override
	public String hash(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hashedBytes = digest.digest(password.getBytes());
			return Base64.getEncoder().encodeToString(hashedBytes);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}


	@Override
	public boolean verifyHash(String password, String hashedPassword) {
		String hashedGivenPassword = hash(password);
		return hashedGivenPassword.equals(hashedPassword);
	}
}
