package com.angel.infrastructure.db.orm;

import com.angel.application.consts.RoleType;
import com.angel.infrastructure.db.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleORM extends JpaRepository<RoleModel, String> {

	Optional<RoleModel> findByRoleType(RoleType roleType);
}