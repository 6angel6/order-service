package com.angel.application.interfaces.persistence;

import com.angel.application.dto.query.UserQueryDTO;

import java.util.List;
import java.util.UUID;

public interface UserReader {

	List<UserQueryDTO> getUsers();

	UserQueryDTO getUserById(UUID id);

	UserQueryDTO getUserByUsername(String username);

	UserQueryDTO getUserByEmail(String email);


}
