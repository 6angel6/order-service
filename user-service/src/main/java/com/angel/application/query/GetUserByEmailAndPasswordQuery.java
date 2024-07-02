package com.angel.application.query;

import com.angel.application.dto.query.UserQueryDTO;
import com.angel.application.exeptions.PasswordsDoNotMatch;
import com.angel.application.interfaces.persistence.UserReader;
import com.angel.application.interfaces.security.PasswordEncoder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetUserByEmailAndPasswordQuery {

	private final UserReader userReader;
	private final PasswordEncoder passwordEncoder;

	public UserQueryDTO handle(String email, String password) {
		UserQueryDTO userQueryDTO = userReader.getUserByEmail(email);
		if (passwordEncoder.verifyHash(password, userQueryDTO.password)) {
			return userQueryDTO;
		} else {
			throw new PasswordsDoNotMatch();
		}
	}
}