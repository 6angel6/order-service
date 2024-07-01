package com.angel.domain.user.service;

import com.angel.domain.user.entity.User;
import com.angel.domain.user.events.UserCreatedEvent;
import com.angel.domain.user.vo.Role;
import com.angel.domain.user.vo.UserID;

import java.util.Set;

public class UserService {

	public User create(Set<Role> roles, String firstName, String lastName, String username,
	                   String email, String password){
		User createdUser = new User(new UserID(), roles, firstName,
				lastName, username , email, false , password);

		createdUser.validate();

		createdUser.recordEvent(new UserCreatedEvent(createdUser.getUserID().getID(),
				username, firstName, lastName, email));

		return  createdUser;
	}
}
