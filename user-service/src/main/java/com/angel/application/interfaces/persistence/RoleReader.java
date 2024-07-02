package com.angel.application.interfaces.persistence;

import com.angel.application.consts.RoleType;
import com.angel.domain.user.vo.Role;

public interface RoleReader {

	Role getRoleByType(RoleType roleType);
}