package com.angel.application.interfaces.persistence;

import com.angel.domain.user.entity.User;

public interface UserDao {

	User createUser(User user);

	User updateUser(User user);

	User deleteUser(User user);

}
