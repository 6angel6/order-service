package com.angel.infrastructure.db.impl;

import com.angel.application.consts.RoleType;
import com.angel.application.exeptions.RoleNotFoundException;
import com.angel.application.interfaces.persistence.RoleReader;
import com.angel.domain.user.vo.Role;
import com.angel.infrastructure.db.models.RoleModel;
import com.angel.infrastructure.db.orm.RoleORM;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoleDAOimpl implements RoleReader {

	private final RoleORM roleORM;

	@Override
	public Role getRoleByType(RoleType roleType) {
		RoleModel maybeRole = roleORM.findByRoleType(roleType).orElseThrow(RoleNotFoundException::new);
		return new Role(maybeRole.getRoleType().name(), maybeRole.getCreatedAt());
	}
}
