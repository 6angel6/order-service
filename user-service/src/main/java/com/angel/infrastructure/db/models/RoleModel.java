package com.angel.infrastructure.db.models;

import com.angel.application.consts.RoleType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "roles", schema = "user_service")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class RoleModel {

	@Id
	@Enumerated(EnumType.STRING)
	@Column(name = "role_type", nullable = false, unique = true, length = 20)
	private RoleType roleType;

	@Column(name = "created_at", columnDefinition = "timestamptz")
	private LocalDateTime createdAt;
}
