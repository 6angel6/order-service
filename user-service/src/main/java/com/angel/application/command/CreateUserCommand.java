package com.angel.application.command;

import com.angel.application.consts.RoleType;
import com.angel.application.dto.command.CreateUserCommandDTO;
import com.angel.application.exeptions.PasswordsDoNotMatch;
import com.angel.application.interfaces.persistence.RoleReader;
import com.angel.application.interfaces.persistence.UserDao;
import com.angel.domain.user.entity.User;
import com.angel.domain.user.service.UserService;
import com.angel.domain.user.vo.Role;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class CreateUserCommand {

	private final UserService userService;
	private final UserDao userDAO;
	private final RoleReader roleReader;

	public User handle(CreateUserCommandDTO createUserCommandDTO){
		if (!createUserCommandDTO.password.equals(createUserCommandDTO.repeatPassword)) {
			throw new PasswordsDoNotMatch();
		}
		Set<Role> roles = new HashSet<>();
		roles.add(roleReader.getRoleByType(RoleType.ROLE_USER));
		User createdUser = userService.create(roles, createUserCommandDTO.firstName, createUserCommandDTO.lastName,
				createUserCommandDTO.username, createUserCommandDTO.email, createUserCommandDTO.password);
		return userDAO.createUser(createdUser);
	}
}
