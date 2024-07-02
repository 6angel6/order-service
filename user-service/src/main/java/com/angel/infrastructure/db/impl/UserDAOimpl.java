package com.angel.infrastructure.db.impl;

import com.angel.application.dto.query.UserQueryDTO;
import com.angel.application.exeptions.UserNotFoundException;
import com.angel.application.interfaces.persistence.UserDao;
import com.angel.application.interfaces.persistence.UserReader;
import com.angel.domain.user.entity.User;
import com.angel.infrastructure.db.models.UserModel;
import com.angel.infrastructure.db.orm.Mapper.UserMapper;
import com.angel.infrastructure.db.orm.UserORM;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class UserDAOimpl implements UserDao, UserReader {

	private final UserORM userORM;

	@Override
	public User createUser(User user) {
		UserModel createdUser = userORM.save(UserMapper.convertUserEntityToModel(user));
		return UserMapper.convertUserModelToEntity(createdUser);
	}

	@Override
	public User updateUser(User user) {
		UserModel maybeUser = userORM.findById(user.getUserID().getID()).orElseThrow(
				UserNotFoundException::new);
		UserModel updatedUser = userORM.save(UserMapper.convertUserEntityToModel(user));
		return UserMapper.convertUserModelToEntity(updatedUser);
	}

	@Override
	public User deleteUser(User user) {
		return null;
	}

	@Override
	public List<UserQueryDTO> getUsers() {
		return null;
	}

	@Override
	public UserQueryDTO getUserById(UUID id) {
		UserModel maybeUser = userORM.findById(id).orElseThrow(
				UserNotFoundException::new);
		return UserMapper.convertUserModelToQueryDTO(maybeUser);
	}

	@Override
	public UserQueryDTO getUserByUsername(String username) {
		UserModel maybeUser = userORM.findByUsername(username).orElseThrow(
				UserNotFoundException::new);
		return UserMapper.convertUserModelToQueryDTO(maybeUser);
	}

	@Override
	public UserQueryDTO getUserByEmail(String email) {
		UserModel maybeUser = userORM.findByEmail(email).orElseThrow(
				UserNotFoundException::new);
		return UserMapper.convertUserModelToQueryDTO(maybeUser);
	}
}
