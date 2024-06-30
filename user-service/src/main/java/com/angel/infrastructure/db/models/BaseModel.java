package com.angel.infrastructure.db.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {

	@Id
	private UUID id;

	@Column(name = "created_at" , columnDefinition = "timestamptz", updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "created_at" , columnDefinition = "timestamptz", updatable = false)
	private LocalDateTime updatedAt;

	@Column(name = "created_at" , columnDefinition = "timestamptz", updatable = false)
	private LocalDateTime deletedAt;

	@Column(name = "created_at" , columnDefinition = "timestamptz", updatable = false)
	private boolean deleted;

	@PrePersist
	protected void onCreate(){
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = LocalDateTime.now();
	}
}
