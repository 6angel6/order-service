package com.angel.application.dto.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class AuthUserQueryDTO {

	@JsonProperty("user_id")
	public String userID;

	@JsonProperty("roles")
	public List<String> roles;
}
