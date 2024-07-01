package com.angel.domain.user.entity;

import com.angel.domain.common.aggreagete.Aggregate;
import com.angel.domain.user.execptions.InvalidEmailException;
import com.angel.domain.user.execptions.InvalidFirstNameException;
import com.angel.domain.user.execptions.InvalidPasswordException;
import com.angel.domain.user.execptions.InvalidUsernameException;
import com.angel.domain.user.vo.Role;
import com.angel.domain.user.vo.UserID;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class User extends Aggregate {

	private UserID userID;
	private Set<Role> roles;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private boolean emailConfirmed;
	private String password;

	public boolean validate(){
		return validateEmail() &&
				validatePassword() &&
				validateUsername() &&
				validateFirstName();
	}

	public boolean validateFirstName() {
		if (this.firstName.length() < 2) {
			throw InvalidFirstNameException.invalidLength();
		}
		String invalidChars = validationCharacters(this.firstName);
		if (invalidChars != null) {
			throw InvalidFirstNameException.invalidCharactersOccurred(invalidChars);
		}
		return true;
	}

	public boolean validateUsername() {
		if (this.username.length() < 5) {
			throw InvalidUsernameException.invalidLength();
		}
		String invalidChars = validationCharacters(this.username);
		if (invalidChars != null) {
			throw InvalidUsernameException.invalidCharactersOccurred(invalidChars);
		}
		return true;
	}

	public boolean validateEmail() {
		if (this.email.length() < 5) {
			throw InvalidEmailException.invalidLength();
		}
		Matcher emailMatcher = Pattern.compile("^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$").matcher(this.email);
		if (emailMatcher.find()) {
			throw InvalidEmailException.invalidEmailFormat();
		}
		return true;
	}

	public boolean validatePassword() {
		if (this.password.length() < 4) {
			throw InvalidPasswordException.invalidLength();
		}
		if (!this.password.contains("!") || !this.password.contains(".") || !this.password.contains("_")) {
			throw InvalidPasswordException.noSpecialChars();
		}
		if (this.password.chars().noneMatch(Character::isDigit)) {
			throw InvalidPasswordException.noDigit();
		}
		if (this.password.chars().noneMatch(Character::isUpperCase)) {
			throw InvalidPasswordException.noUpperCase();
		}
		return true;
	}

	private String validationCharacters(String target) {
		char[] filterChars = {'%', '$', '@', '=', '-', '/'};
		return target.chars()
				.filter(c -> new String(filterChars).indexOf(c) != -1)
				.mapToObj(c -> String.valueOf((char) c))
				.collect(Collectors.joining());
	}


	public User(UserID userID, Set<Role> roles, String firstName, String lastName, String username, String email, boolean emailConfirmed, String password) {
		this.userID = userID;
		this.roles = roles;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.emailConfirmed = emailConfirmed;
		this.password = password;
	}

	public UserID getUserID() {
		return userID;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}

	public String getPassword() {
		return password;
	}

}
