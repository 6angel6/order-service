package com.angel.infrastructure.db.orm.Mapper;

import com.angel.application.consts.RoleType;
import com.angel.application.dto.query.UserQueryDTO;
import com.angel.domain.user.entity.User;
import com.angel.domain.user.vo.Role;
import com.angel.domain.user.vo.UserID;
import com.angel.infrastructure.db.models.RoleModel;
import com.angel.infrastructure.db.models.UserModel;

import java.util.stream.Collectors;

public class UserMapper {

	public static UserQueryDTO convertUserModelToQueryDTO(UserModel model) {
		return new UserQueryDTO(model.getId().toString(), model.getFirstName(), model.getLastName(),
				model.getUsername(), model.getEmail(), model.getPassword(), model.isEmailConfirmed(),
				model.getRoles().stream().map(e -> e.getRoleType().toString()).toList());
	}

	public static User convertUserModelToEntity(UserModel model) {
		return new User(new UserID(model.getId()), model.getRoles().stream().map(UserMapper::convertRoleModelToEntity).collect(Collectors.toSet()),
				model.getFirstName(), model.getLastName(), model.getUsername(),
				model.getEmail(), model.isEmailConfirmed(), model.getPassword());
	}

	public static UserModel convertUserEntityToModel(User entity) {
		return new UserModel(entity.getUserID().getID(), entity.getFirstName(), entity.getLastName(), entity.getUsername(),
				entity.getEmail(), entity.isEmailConfirmed(), entity.getPassword(),
				entity.getRoles().stream().map(UserMapper::convertRoleEntityToModel).collect(Collectors.toSet()));
	}

	public static Role convertRoleModelToEntity(RoleModel model) {
		return new Role(model.getRoleType().toString(), model.getCreatedAt());
	}

	public static RoleModel convertRoleEntityToModel(Role entity) {
		return new RoleModel(RoleType.valueOf(entity.getRoleType()), entity.getCreatedAt());
	}
}
